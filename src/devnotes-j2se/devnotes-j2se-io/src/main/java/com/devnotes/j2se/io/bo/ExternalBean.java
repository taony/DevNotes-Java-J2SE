package com.devnotes.j2se.io.bo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalBean implements Externalizable {
    private           String loginName;
    private transient String loginPwd;
    private transient String phone;

    private ExternalBean instance;

    public ExternalBean() {

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(instance);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.instance = (ExternalBean) in.readObject();
    }
}
