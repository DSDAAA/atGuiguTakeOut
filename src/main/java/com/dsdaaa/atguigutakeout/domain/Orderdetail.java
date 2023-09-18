package com.dsdaaa.atguigutakeout.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName orderdetail
 */
@TableName(value ="orderdetail")
@Data
public class Orderdetail implements Serializable {
    /**
     *
     */
    @TableId
    private String detailid;

    /**
     *
     */
    private String orderid;

    /**
     *
     */
    private String productid;

    /**
     *
     */
    private Integer productcount;

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
        Orderdetail other = (Orderdetail) that;
        return (this.getDetailid() == null ? other.getDetailid() == null : this.getDetailid().equals(other.getDetailid()))
            && (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getProductid() == null ? other.getProductid() == null : this.getProductid().equals(other.getProductid()))
            && (this.getProductcount() == null ? other.getProductcount() == null : this.getProductcount().equals(other.getProductcount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailid() == null) ? 0 : getDetailid().hashCode());
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getProductid() == null) ? 0 : getProductid().hashCode());
        result = prime * result + ((getProductcount() == null) ? 0 : getProductcount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailid=").append(detailid);
        sb.append(", orderid=").append(orderid);
        sb.append(", productid=").append(productid);
        sb.append(", productcount=").append(productcount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
