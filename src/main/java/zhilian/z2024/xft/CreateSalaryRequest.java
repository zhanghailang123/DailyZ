package zhilian.z2024.xft;

import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-06-26
 */
public class CreateSalaryRequest {

    /**
     * BATNAM : 批次名称
     * DURTAX : 202205
     * INCTYP : 1
     * INCITE : 01
     * USLSPE : N
     * CALIMD : Y
     * BUSNBR : 66666666
     */

    private List<TXCRTBATXBean> TXCRTBATX;

    /**
     * STFNAM : 测试人
     * STFSEQ : TAX000000000002
     * CERTYP : A
     * CERNBR : 330102199201011183
     * REGSEQ : 10117440185713003912-001
     * REVCOU : 10000
     * CRMSSD : 100
     * JBYLBX : 100
     * JBYIBX : 100
     * SYVXYE : 100
     * ZFGJJY : 100
     * LJYYEF : 100
     * LJZNJY : 100
     * LJJXJY : 100
     * LJFWDK : 100
     * LJZFZJ : 100
     * ZYKCJK : 0.00
     * JMSEZD : 100
     * REMARK : 备注
     * ISSAVE : true
     * ACDNAM : 0.00
     * SEQNBR : 0
     * ROWNBR : 2
     */

    private List<TXSTFSALXBean> TXSTFSALX;

    /**
     * REGSEQ : 10117440185713003912-001
     * PWDTYP : 0
     * DCLPWD : Aa123456
     */

    private List<TXREGPWDXBean> TXREGPWDX;

    public List<TXCRTBATXBean> getTXCRTBATX() {return TXCRTBATX;}

    public void setTXCRTBATX(List<TXCRTBATXBean> TXCRTBATX) {this.TXCRTBATX = TXCRTBATX;}

    public List<TXSTFSALXBean> getTXSTFSALX() {return TXSTFSALX;}

    public void setTXSTFSALX(List<TXSTFSALXBean> TXSTFSALX) {this.TXSTFSALX = TXSTFSALX;}

    public List<TXREGPWDXBean> getTXREGPWDX() {return TXREGPWDX;}

    public void setTXREGPWDX(List<TXREGPWDXBean> TXREGPWDX) {this.TXREGPWDX = TXREGPWDX;}

    public static class TXCRTBATXBean {

        private String BATNAM;

        private String DURTAX;

        private String INCTYP;

        private String INCITE;

        private String USLSPE;

        private String personalPensionStrategy;

        private String CALIMD;

        private String BUSNBR;

        public TXCRTBATXBean() {}

        public String getBATNAM() {return BATNAM;}

        public void setBATNAM(String BATNAM) {this.BATNAM = BATNAM;}

        public String getDURTAX() {return DURTAX;}

        public void setDURTAX(String DURTAX) {this.DURTAX = DURTAX;}

        public String getINCTYP() {return INCTYP;}

        public void setINCTYP(String INCTYP) {this.INCTYP = INCTYP;}

        public String getINCITE() {return INCITE;}

        public void setINCITE(String INCITE) {this.INCITE = INCITE;}

        public String getUSLSPE() {return USLSPE;}

        public void setUSLSPE(String USLSPE) {this.USLSPE = USLSPE;}

        public String getCALIMD() {return CALIMD;}

        public void setCALIMD(String CALIMD) {this.CALIMD = CALIMD;}

        public String getBUSNBR() {return BUSNBR;}

        public void setBUSNBR(String BUSNBR) {this.BUSNBR = BUSNBR;}

        public String getPersonalPensionStrategy() {
            return personalPensionStrategy;
        }

        public void setPersonalPensionStrategy(String personalPensionStrategy) {
            this.personalPensionStrategy = personalPensionStrategy;
        }
    }

    public static class TXSTFSALXBean {

        private String STFNAM;

        private String STFSEQ;

        private String APISEQ;

        private String CERTYP;

        private String CERNBR;

        private String REGSEQ;

        private String REVCOU;

        private String CRMSSD;

        private String JBYLBX;

        private String JBYIBX;

        private String SYVXYE;

        private String ZFGJJY;

        private String LJYYEF;

        private String LJZNJY;

        private String LJJXJY;

        private String LJFWDK;

        private String LJZFZJ;

        private String ZYKCJK;

        private String JMSEZD;

        private String REMARK;

        private boolean ISSAVE;

        private String ACDNAM;

        private int SEQNBR;

        private int ROWNBR;

        public String getSTFNAM() {return STFNAM;}

        public void setSTFNAM(String STFNAM) {this.STFNAM = STFNAM;}

        public String getSTFSEQ() {return STFSEQ;}

        public void setSTFSEQ(String STFSEQ) {this.STFSEQ = STFSEQ;}

        public String getCERTYP() {return CERTYP;}

        public void setCERTYP(String CERTYP) {this.CERTYP = CERTYP;}

        public String getCERNBR() {return CERNBR;}

        public void setCERNBR(String CERNBR) {this.CERNBR = CERNBR;}

        public String getREGSEQ() {return REGSEQ;}

        public void setREGSEQ(String REGSEQ) {this.REGSEQ = REGSEQ;}

        public String getREVCOU() {return REVCOU;}

        public void setREVCOU(String REVCOU) {this.REVCOU = REVCOU;}

        public String getCRMSSD() {return CRMSSD;}

        public void setCRMSSD(String CRMSSD) {this.CRMSSD = CRMSSD;}

        public String getJBYLBX() {return JBYLBX;}

        public void setJBYLBX(String JBYLBX) {this.JBYLBX = JBYLBX;}

        public String getJBYIBX() {return JBYIBX;}

        public void setJBYIBX(String JBYIBX) {this.JBYIBX = JBYIBX;}

        public String getSYVXYE() {return SYVXYE;}

        public void setSYVXYE(String SYVXYE) {this.SYVXYE = SYVXYE;}

        public String getZFGJJY() {return ZFGJJY;}

        public void setZFGJJY(String ZFGJJY) {this.ZFGJJY = ZFGJJY;}

        public String getLJYYEF() {return LJYYEF;}

        public void setLJYYEF(String LJYYEF) {this.LJYYEF = LJYYEF;}

        public String getLJZNJY() {return LJZNJY;}

        public void setLJZNJY(String LJZNJY) {this.LJZNJY = LJZNJY;}

        public String getLJJXJY() {return LJJXJY;}

        public void setLJJXJY(String LJJXJY) {this.LJJXJY = LJJXJY;}

        public String getLJFWDK() {return LJFWDK;}

        public void setLJFWDK(String LJFWDK) {this.LJFWDK = LJFWDK;}

        public String getLJZFZJ() {return LJZFZJ;}

        public void setLJZFZJ(String LJZFZJ) {this.LJZFZJ = LJZFZJ;}

        public String getZYKCJK() {return ZYKCJK;}

        public void setZYKCJK(String ZYKCJK) {this.ZYKCJK = ZYKCJK;}

        public String getJMSEZD() {return JMSEZD;}

        public void setJMSEZD(String JMSEZD) {this.JMSEZD = JMSEZD;}

        public String getREMARK() {return REMARK;}

        public void setREMARK(String REMARK) {this.REMARK = REMARK;}

        public boolean isISSAVE() {return ISSAVE;}

        public void setISSAVE(boolean ISSAVE) {this.ISSAVE = ISSAVE;}

        public String getACDNAM() {return ACDNAM;}

        public void setACDNAM(String ACDNAM) {this.ACDNAM = ACDNAM;}

        public int getSEQNBR() {return SEQNBR;}

        public void setSEQNBR(int SEQNBR) {this.SEQNBR = SEQNBR;}

        public int getROWNBR() {return ROWNBR;}

        public void setROWNBR(int ROWNBR) {this.ROWNBR = ROWNBR;}

        public String getAPISEQ() {
            return APISEQ;
        }

        public void setAPISEQ(String APISEQ) {
            this.APISEQ = APISEQ;
        }
    }

    public static class TXREGPWDXBean {

        private String REGSEQ;

        private String PWDTYP;

        private String DCLPWD;

        public String getREGSEQ() {return REGSEQ;}

        public void setREGSEQ(String REGSEQ) {this.REGSEQ = REGSEQ;}

        public String getPWDTYP() {return PWDTYP;}

        public void setPWDTYP(String PWDTYP) {this.PWDTYP = PWDTYP;}

        public String getDCLPWD() {return DCLPWD;}

        public void setDCLPWD(String DCLPWD) {this.DCLPWD = DCLPWD;}
    }
}