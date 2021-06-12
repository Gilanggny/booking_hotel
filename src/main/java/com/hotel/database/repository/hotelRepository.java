package com.hotel.database.repository;

import com.hotel.database.dbresponse.send;
import com.hotel.database.model.Hotel;
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
                orderHotel.calculateFinalDate();
                orderHotel.calculatePrice();

                session.insert("daftarHotel.insertOrder", orderHotel);

                Hotel findHotel = session.selectOne("daftarHotel.searchHotelName", orderHotel.getHotel());

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

                System.out.println("Update");
                System.out.println(
                        "Nama Hotel : " + findHotel.getName() +
                                "\nKapasitas Hotel : " + findHotel.getKamar() +
                                "\nKamar Kosong : " + findHotel.getTersedia() +
                                "\nKamar Terisi : " + findHotel.getTerpakai()
                );

                session.update("daftarHotel.updateHotel", findHotel);

                sendMessage.sendOrderResponseToRestController(orderHotel);

                session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
