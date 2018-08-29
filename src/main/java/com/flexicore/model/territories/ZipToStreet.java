package com.flexicore.model.territories;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ZipToStreet extends Baselink {

    static private ZipToStreet s_Singleton = new ZipToStreet();

    static public ZipToStreet s() {
        return s_Singleton;
    }

    @Override
    @ManyToOne(targetEntity = Zip.class)
    public Zip getLeftside() {
        return (Zip) leftside;
    }

    public void setLeftside(Zip leftside) {
        this.leftside = leftside;
    }

    @Override
    public void setLeftside(Baseclass leftside) {
        this.leftside = leftside;
    }

    @ManyToOne(targetEntity = Street.class)
    @Override
    public Street getRightside() {
        return (Street) rightside;
    }

    @Override
    public void setRightside(Baseclass rightside) {
        this.rightside = rightside;
    }

    public void setRightside(Street rightside) {
        this.rightside = rightside;
    }

}