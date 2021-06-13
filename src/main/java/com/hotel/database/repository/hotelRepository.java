package com.hotel.database.repository;

import com.google.gson.Gson;
import com.hotel.database.dbresponse.send;
import com.hotel.database.model.Hotel;
import com.hotel.database.model.Message;
import com.hotel.database.model.OrderHotel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class hotelRepository {
    private SqlSession session;
    private send sendMessage = new send();

    public void connectMyBatis() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }

    public void requestListHotel() throws IOException, TimeoutException {
        System.out.println("Memulai Proses Pengambilan Data User ....");
        connectMyBatis();
        try{
            List<Hotel> dataHotel = session.selectList("daftarHotel.getAllHotelList");
            session.commit();
            sendMessage.sendListUserToRestController(dataHotel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void orderHotel(OrderHotel orderHotel) throws IOException, TimeoutException {
        System.out.println("Memulai Proses Pengambilan Data User ....");
        connectMyBatis();
        try{
            Hotel findHotel = session.selectOne("daftarHotel.searchHotelName", orderHotel.getHotel());
            orderHotel.calculateFinalDate();
            orderHotel.calculatePrice(findHotel.getHarga());

            // Memeriksa apakah hotel penuh atau tidak
            if (findHotel.getTersedia() != 0){
                session.insert("daftarHotel.insertOrder", orderHotel);
                System.out.println(
                        "Nama Hotel : " + findHotel.getName() +
                                "\nKapasitas Hotel : " + findHotel.getKamar() +
                                "\nKamar Kosong : " + findHotel.getTersedia() +
                                "\nKamar Terisi : " + findHotel.getTerpakai()
                );

                findHotel.getTerpakai();
                findHotel.getTersedia();
                findHotel.kurangiTersedia();
                findHotel.tambahTerpakai();

                System.out.println("--------------------------------------------------------------------");
                System.out.println("Update");
                System.out.println("--------------------------------------------------------------------");
                System.out.println(
                        "Nama Hotel : " + findHotel.getName() +
                                "\nKapasitas Hotel : " + findHotel.getKamar() +
                                "\nKamar Kosong : " + findHotel.getTersedia() +
                                "\nKamar Terisi : " + findHotel.getTerpakai()
                );

                session.update("daftarHotel.updateHotel", findHotel);

                String sendJSON = new Gson().toJson(orderHotel);
                sendMessage.sendOrderResponseToRestController(sendJSON);

                session.commit();
            } else {
                Message inputMessage = new Message("Hotel Penuh");
                String sendJSON = new Gson().toJson(inputMessage);
                sendMessage.sendOrderResponseToRestController(sendJSON);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
