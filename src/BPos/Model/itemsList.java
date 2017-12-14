/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPos.Model;

import BPos.DB.QtyType;
import java.util.Date;

/**
 *
 * @author Bhagya
 */
public class itemsList {
    
    private String productID;
    private String Name;
    private String Description;
    private double price;
    private double sellingPrice;
    private double Qty;
    private double SubAmount;
    private Date ExDate;
    private int StockID;
    private int Discount;
    private double Grandtot;
    private QtyType Types;
    private String CanLoosing;
    
    

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return Qty;
    }

    public void setQty(double Qty) {
        this.Qty = Qty;
    }

    public double getSubAmount() {
        return SubAmount;
    }

    public void setSubAmount(double SubAmount) {
        this.SubAmount = SubAmount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getExDate() {
        return ExDate;
    }

    public void setExDate(Date ExDate) {
        this.ExDate = ExDate;
    }

    public int getStockID() {
        return StockID;
    }

    public void setStockID(int StockID) {
        this.StockID = StockID;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDescount(int Discount) {
        this.Discount = Discount;
    }

    public double getGrandtot() {
        return Grandtot;
    }

    public void setGrandtot(double Grandtot) {
        this.Grandtot = Grandtot;
    }

    /**
     * @return the Types
     */
    public QtyType getTypes() {
        return Types;
    }

    /**
     * @param Types the Types to set
     */
    public void setTypes(QtyType Types) {
        this.Types = Types;
    }

    /**
     * @return the CanLoosing
     */
    public String getCanLoosing() {
        return CanLoosing;
    }

    /**
     * @param CanLoosing the CanLoosing to set
     */
    public void setCanLoosing(String CanLoosing) {
        this.CanLoosing = CanLoosing;
    }

}
