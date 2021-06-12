package com.hotel.database.repository;

import com.hotel.database.dbresponse.send;
import com.hotel.database.model.Hotel;
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
//            sendMessage.sendListUserToRestController(dataUser);
            sendMessage.sendListUserToRestController(dataHotel);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
