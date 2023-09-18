package com.dsdaaa.atguigutakeout.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName food
 */
@TableName(value ="food")
@Data
public class Food implements Serializable {
    /**
     *
     */
    @TableId
    private String foodid;

    /**
     *
     */
    private String foodname;

    /**
     *
     */
    private Double foodprice;

    /**
     *
     */
    private String fooddesc;

    /**
     *
     */
    private String foodicon;

    /**
     *
     */
    private String foodimage;

    /**
     *
     */
    private Integer foodtypeid;

    /**
     *
     */
    private Integer foodstatus;

    /**
     *
     */
    private Integer foodcount;

    /**
     *
     */
    private Date createtime;

    /**
     *
     */
    private Date updatetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Food other = (Food) that;
        return (this.getFoodid() == null ? other.getFoodid() == null : this.getFoodid().equals(other.getFoodid()))
            && (this.getFoodname() == null ? other.getFoodname() == null : this.getFoodname().equals(other.getFoodname()))
            && (this.getFoodprice() == null ? other.getFoodprice() == null : this.getFoodprice().equals(other.getFoodprice()))
            && (this.getFooddesc() == null ? other.getFooddesc() == null : this.getFooddesc().equals(other.getFooddesc()))
            && (this.getFoodicon() == null ? other.getFoodicon() == null : this.getFoodicon().equals(other.getFoodicon()))
            && (this.getFoodimage() == null ? other.getFoodimage() == null : this.getFoodimage().equals(other.getFoodimage()))
            && (this.getFoodtypeid() == null ? other.getFoodtypeid() == null : this.getFoodtypeid().equals(other.getFoodtypeid()))
            && (this.getFoodstatus() == null ? other.getFoodstatus() == null : this.getFoodstatus().equals(other.getFoodstatus()))
            && (this.getFoodcount() == null ? other.getFoodcount() == null : this.getFoodcount().equals(other.getFoodcount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFoodid() == null) ? 0 : getFoodid().hashCode());
        result = prime * result + ((getFoodname() == null) ? 0 : getFoodname().hashCode());
        result = prime * result + ((getFoodprice() == null) ? 0 : getFoodprice().hashCode());
        result = prime * result + ((getFooddesc() == null) ? 0 : getFooddesc().hashCode());
        result = prime * result + ((getFoodicon() == null) ? 0 : getFoodicon().hashCode());
        result = prime * result + ((getFoodimage() == null) ? 0 : getFoodimage().hashCode());
        result = prime * result + ((getFoodtypeid() == null) ? 0 : getFoodtypeid().hashCode());
        result = prime * result + ((getFoodstatus() == null) ? 0 : getFoodstatus().hashCode());
        result = prime * result + ((getFoodcount() == null) ? 0 : getFoodcount().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", foodid=").append(foodid);
        sb.append(", foodname=").append(foodname);
        sb.append(", foodprice=").append(foodprice);
        sb.append(", fooddesc=").append(fooddesc);
        sb.append(", foodicon=").append(foodicon);
        sb.append(", foodimage=").append(foodimage);
        sb.append(", foodtypeid=").append(foodtypeid);
        sb.append(", foodstatus=").append(foodstatus);
        sb.append(", foodcount=").append(foodcount);
        sb.append(", createtime=").append(createtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
