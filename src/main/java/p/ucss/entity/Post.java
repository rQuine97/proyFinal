/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.ucss.entity;

/**
 *
 * @author DESEHADAS 3
 */
public class Post {
    private int idproducto;
    private String producto;
    private String marca;
    private int precio;
    private int stock;

    public Post() {
    }

    public Post(int idproducto, String producto, String marca, int precio, int stock) {
        this.idproducto = idproducto;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public String getProducto() {
        return producto;
    }

    public String getMarca() {
        return marca;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}