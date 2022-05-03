/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p.ucss.daomlp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p.ucss.config.Conexion;
import p.ucss.dao.PostDao;
import p.ucss.entity.Post;

/**
 *
 * @author admin
 */
public class PostDaoImpl implements PostDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Post post) {
        String SQL ="INSERT INTO post(producto ,marca ,precio ,stock) VALUES(?,?,?,?)";
        
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getProducto());
            ps.setString(2, post.getMarca());
            ps.setInt(3, post.getPrecio());
            ps.setInt(4, post.getStock());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Post post) {
        String SQL ="UPDATE post SET producto=?, marca=?, precio=? , stock=? WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getProducto());
            ps.setString(2, post.getMarca());
            ps.setInt(3, post.getPrecio());
            ps.setInt(4, post.getStock());
            ps.setInt(5, post.getIdproducto());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM post WHERE idproducto=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Post read(int id) {
        String SQL ="SELECT *FROM post WHERE idproducto=?";
        Post post = new Post();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                
                post.setIdproducto(rs.getInt("idproducto"));
                post.setProducto(rs.getString("producto"));
                post.setMarca(rs.getString("marca"));
                post.setPrecio(rs.getInt("precio"));
                post.setStock(rs.getInt("stock"));
                
            }            
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return post;
    }

    @Override
    public List<Post> readAll() {
        String SQL ="SELECT *FROM post";
        List<Post> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setIdproducto(rs.getInt("idproducto"));
                post.setProducto(rs.getString("producto"));
                post.setMarca(rs.getString("marca"));
                post.setPrecio(rs.getInt("precio"));
                post.setStock(rs.getInt("stock"));
                lista.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
