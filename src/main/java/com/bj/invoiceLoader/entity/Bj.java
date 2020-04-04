package com.bj.invoiceLoader.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bj {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String ico;

    private String dic;

    private String company;

    private String name;

    private String forename;

    private String street;

    private String psc;

    private String city;

    private String email;

    private String email_copy;

    private Integer group_flag;

    private String t1;

    private String tar1;

    private Integer m1;

    private String t2;

    private String tar2;

    private Integer m2;

    private String t3;

    private String tar3;

    private Integer m3;

    private String t4;

    private String tar4;

    private Integer m4;

    private String t5;

    private String tar5;

    private Integer m5;

    private String t6;

    private String tar6;

    private Integer m6;

    private String t7;

    private String tar7;

    private Integer m7;

    private String t8;

    private String tar8;

    private Integer m8;

    private String t9;

    private String tar9;

    private Integer m9;

    private String t10;

    private String tar10;

    private Integer m10;

    private String t11;

    private String tar11;

    private Integer m11;

    private String t12;

    private String tar12;

    private Integer m12;

    private String t13;

    private String tar13;

    private Integer m13;

    private String t14;

    private String tar14;

    private Integer m14;

    private String t15;

    private String tar15;

    private Integer m15;

    private String t16;

    private String tar16;

    private Integer m16;

    private String t17;

    private String tar17;

    private Integer m17;

    private String excelId;

    private Boolean companyFlag;

    public Bj() {
    }

    public Bj(String ico, String dic, String company, String name, String forename, String street, String psc, String city, String email, String email_copy, Integer group_flag, String t1, String tar1, Integer m1, String t2, String tar2, Integer m2, String t3, String tar3, Integer m3, String t4, String tar4, Integer m4, String t5, String tar5, Integer m5, String t6, String tar6, Integer m6, String t7, String tar7, Integer m7, String t8, String tar8, Integer m8, String t9, String tar9, Integer m9, String t10, String tar10, Integer m10, String t11, String tar11, Integer m11, String t12, String tar12, Integer m12, String t13, String tar13, Integer m13, String t14, String tar14, Integer m14, String t15, String tar15, Integer m15, String t16, String tar16, Integer m16, String t17, String tar17, Integer m17, String excelId, Boolean companyFlag) {
        this.ico = ico;
        this.dic = dic;
        this.company = company;
        this.name = name;
        this.forename = forename;
        this.street = street;
        this.psc = psc;
        this.city = city;
        this.email = email;
        this.email_copy = email_copy;
        this.group_flag = group_flag;
        this.t1 = t1;
        this.tar1 = tar1;
        this.m1 = m1;
        this.t2 = t2;
        this.tar2 = tar2;
        this.m2 = m2;
        this.t3 = t3;
        this.tar3 = tar3;
        this.m3 = m3;
        this.t4 = t4;
        this.tar4 = tar4;
        this.m4 = m4;
        this.t5 = t5;
        this.tar5 = tar5;
        this.m5 = m5;
        this.t6 = t6;
        this.tar6 = tar6;
        this.m6 = m6;
        this.t7 = t7;
        this.tar7 = tar7;
        this.m7 = m7;
        this.t8 = t8;
        this.tar8 = tar8;
        this.m8 = m8;
        this.t9 = t9;
        this.tar9 = tar9;
        this.m9 = m9;
        this.t10 = t10;
        this.tar10 = tar10;
        this.m10 = m10;
        this.t11 = t11;
        this.tar11 = tar11;
        this.m11 = m11;
        this.t12 = t12;
        this.tar12 = tar12;
        this.m12 = m12;
        this.t13 = t13;
        this.tar13 = tar13;
        this.m13 = m13;
        this.t14 = t14;
        this.tar14 = tar14;
        this.m14 = m14;
        this.t15 = t15;
        this.tar15 = tar15;
        this.m15 = m15;
        this.t16 = t16;
        this.tar16 = tar16;
        this.m16 = m16;
        this.t17 = t17;
        this.tar17 = tar17;
        this.m17 = m17;
        this.excelId = excelId;
        this.companyFlag = companyFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_copy() {
        return email_copy;
    }

    public void setEmail_copy(String email_copy) {
        this.email_copy = email_copy;
    }

    public Integer getGroup_flag() {
        return group_flag;
    }

    public void setGroup_flag(Integer group_flag) {
        this.group_flag = group_flag;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getTar1() {
        return tar1;
    }

    public void setTar1(String tar1) {
        this.tar1 = tar1;
    }

    public Integer getM1() {
        return m1;
    }

    public void setM1(Integer m1) {
        this.m1 = m1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getTar2() {
        return tar2;
    }

    public void setTar2(String tar2) {
        this.tar2 = tar2;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    public String getT3() {
        return t3;
    }

    public void setT3(String t3) {
        this.t3 = t3;
    }

    public String getTar3() {
        return tar3;
    }

    public void setTar3(String tar3) {
        this.tar3 = tar3;
    }

    public Integer getM3() {
        return m3;
    }

    public void setM3(Integer m3) {
        this.m3 = m3;
    }

    public String getT4() {
        return t4;
    }

    public void setT4(String t4) {
        this.t4 = t4;
    }

    public String getTar4() {
        return tar4;
    }

    public void setTar4(String tar4) {
        this.tar4 = tar4;
    }

    public Integer getM4() {
        return m4;
    }

    public void setM4(Integer m4) {
        this.m4 = m4;
    }

    public String getT5() {
        return t5;
    }

    public void setT5(String t5) {
        this.t5 = t5;
    }

    public String getTar5() {
        return tar5;
    }

    public void setTar5(String tar5) {
        this.tar5 = tar5;
    }

    public Integer getM5() {
        return m5;
    }

    public void setM5(Integer m5) {
        this.m5 = m5;
    }

    public String getT6() {
        return t6;
    }

    public void setT6(String t6) {
        this.t6 = t6;
    }

    public String getTar6() {
        return tar6;
    }

    public void setTar6(String tar6) {
        this.tar6 = tar6;
    }

    public Integer getM6() {
        return m6;
    }

    public void setM6(Integer m6) {
        this.m6 = m6;
    }

    public String getT7() {
        return t7;
    }

    public void setT7(String t7) {
        this.t7 = t7;
    }

    public String getTar7() {
        return tar7;
    }

    public void setTar7(String tar7) {
        this.tar7 = tar7;
    }

    public Integer getM7() {
        return m7;
    }

    public void setM7(Integer m7) {
        this.m7 = m7;
    }

    public String getT8() {
        return t8;
    }

    public void setT8(String t8) {
        this.t8 = t8;
    }

    public String getTar8() {
        return tar8;
    }

    public void setTar8(String tar8) {
        this.tar8 = tar8;
    }

    public Integer getM8() {
        return m8;
    }

    public void setM8(Integer m8) {
        this.m8 = m8;
    }

    public String getT9() {
        return t9;
    }

    public void setT9(String t9) {
        this.t9 = t9;
    }

    public String getTar9() {
        return tar9;
    }

    public void setTar9(String tar9) {
        this.tar9 = tar9;
    }

    public Integer getM9() {
        return m9;
    }

    public void setM9(Integer m9) {
        this.m9 = m9;
    }

    public String getT10() {
        return t10;
    }

    public void setT10(String t10) {
        this.t10 = t10;
    }

    public String getTar10() {
        return tar10;
    }

    public void setTar10(String tar10) {
        this.tar10 = tar10;
    }

    public Integer getM10() {
        return m10;
    }

    public void setM10(Integer m10) {
        this.m10 = m10;
    }

    public String getT11() {
        return t11;
    }

    public void setT11(String t11) {
        this.t11 = t11;
    }

    public String getTar11() {
        return tar11;
    }

    public void setTar11(String tar11) {
        this.tar11 = tar11;
    }

    public Integer getM11() {
        return m11;
    }

    public void setM11(Integer m11) {
        this.m11 = m11;
    }

    public String getT12() {
        return t12;
    }

    public void setT12(String t12) {
        this.t12 = t12;
    }

    public String getTar12() {
        return tar12;
    }

    public void setTar12(String tar12) {
        this.tar12 = tar12;
    }

    public Integer getM12() {
        return m12;
    }

    public void setM12(Integer m12) {
        this.m12 = m12;
    }

    public String getT13() {
        return t13;
    }

    public void setT13(String t13) {
        this.t13 = t13;
    }

    public String getTar13() {
        return tar13;
    }

    public void setTar13(String tar13) {
        this.tar13 = tar13;
    }

    public Integer getM13() {
        return m13;
    }

    public void setM13(Integer m13) {
        this.m13 = m13;
    }

    public String getT14() {
        return t14;
    }

    public void setT14(String t14) {
        this.t14 = t14;
    }

    public String getTar14() {
        return tar14;
    }

    public void setTar14(String tar14) {
        this.tar14 = tar14;
    }

    public Integer getM14() {
        return m14;
    }

    public void setM14(Integer m14) {
        this.m14 = m14;
    }

    public String getT15() {
        return t15;
    }

    public void setT15(String t15) {
        this.t15 = t15;
    }

    public String getTar15() {
        return tar15;
    }

    public void setTar15(String tar15) {
        this.tar15 = tar15;
    }

    public Integer getM15() {
        return m15;
    }

    public void setM15(Integer m15) {
        this.m15 = m15;
    }

    public String getT16() {
        return t16;
    }

    public void setT16(String t16) {
        this.t16 = t16;
    }

    public String getTar16() {
        return tar16;
    }

    public void setTar16(String tar16) {
        this.tar16 = tar16;
    }

    public Integer getM16() {
        return m16;
    }

    public void setM16(Integer m16) {
        this.m16 = m16;
    }

    public String getT17() {
        return t17;
    }

    public void setT17(String t17) {
        this.t17 = t17;
    }

    public String getTar17() {
        return tar17;
    }

    public void setTar17(String tar17) {
        this.tar17 = tar17;
    }

    public Integer getM17() {
        return m17;
    }

    public void setM17(Integer m17) {
        this.m17 = m17;
    }

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId;
    }

    public Boolean getCompanyFlag() {
        return companyFlag;
    }

    public void setCompanyFlag(Boolean companyFlag) {
        this.companyFlag = companyFlag;
    }
}
