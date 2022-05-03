/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.ucss.config;

import com.google.gson.Gson;
import p.ucss.dao.PostDao;
import p.ucss.daomlp.PostDaoImpl;
import p.ucss.entity.Post;

/**
 *
 * @author DESEHADAS 3
 */
public class test {
  static PostDao udao = new PostDaoImpl();
  static Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("SI hay conexión");
        }else{
            System.out.println("NO hay conexión");
        }
    }
    static void listar(){
        System.out.println(gson.toJson(udao.read(111)));
    }
    static void save(){
        System.out.println(udao.create(new Post(0, "mouse", "logitech", 0, 0)));
    }


}
