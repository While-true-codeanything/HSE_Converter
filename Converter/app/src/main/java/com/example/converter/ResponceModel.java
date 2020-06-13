package com.example.converter;

import java.util.ArrayList;

public class ResponceModel {
    public class Rates {
        private double CAD;

        private double HKD;

        private double ISK;

        private double PHP;

        private double DKK;

        private double HUF;

        private double CZK;

        private double AUD;

        private double RON;

        private double SEK;

        private double IDR;

        private double INR;

        private double BRL;

        private double RUB;

        private double HRK;

        private double JPY;

        private double THB;

        private double CHF;

        private double SGD;

        private double PLN;

        private double BGN;

        private double TRY;

        private double CNY;

        private double NOK;

        private double NZD;

        private double ZAR;

        private double USD;

        private double MXN;

        private double ILS;

        private double GBP;

        private double KRW;

        private double MYR;

        public ConverterRow getCAD() {
            return new ConverterRow("CAD", this.CAD);
        }

        public ConverterRow getHKD() {
            return new ConverterRow("HKD", this.HKD);
        }

        public ConverterRow getISK() {
            return new ConverterRow("ISK", this.ISK);
        }

        public ConverterRow getPHP() {
            return new ConverterRow("PHP", this.PHP);
        }

        public ConverterRow getDKK() {
            return new ConverterRow("DKK", this.DKK);
        }

        public ConverterRow getHUF() {
            return new ConverterRow("HUF", this.HUF);
        }

        public ConverterRow getCZK() {
            return new ConverterRow("CZK", this.CZK);
        }

        public ConverterRow getAUD() {
            return new ConverterRow("AUD", this.AUD);
        }

        public ConverterRow getRON() {
            return new ConverterRow("RON", this.RON);
        }

        public ConverterRow getSEK() {
            return new ConverterRow("SEK", this.SEK);
        }

        public ConverterRow getIDR() {
            return new ConverterRow("IDR", this.IDR);
        }

        public ConverterRow getINR() {
            return new ConverterRow("INR", this.INR);
        }

        public ConverterRow getBRL() {
            return new ConverterRow("BRL", this.BRL);
        }

        public ConverterRow getRUB() {
            return new ConverterRow("RUB", this.RUB);
        }

        public ConverterRow getHRK() {
            return new ConverterRow("HRK", this.HRK);
        }

        public ConverterRow getJPY() {
            return new ConverterRow("JPY", this.JPY);
        }

        public ConverterRow getTHB() {
            return new ConverterRow("THB", this.THB);
        }

        public ConverterRow getCHF() {
            return new ConverterRow("CHF", this.CHF);
        }

        public ConverterRow getSGD() {
            return new ConverterRow("SGD", this.SGD);
        }

        public ConverterRow getPLN() {
            return new ConverterRow("PLN", this.PLN);
        }

        public ConverterRow getBGN() {
            return new ConverterRow("BGN", this.BGN);
        }

        public ConverterRow getTRY() {
            return new ConverterRow("TRY", this.TRY);
        }

        public ConverterRow getCNY() {
            return new ConverterRow("CNY", this.CNY);
        }

        public ConverterRow getNOK() {
            return new ConverterRow("NOK", this.NOK);
        }

        public ConverterRow getNZD() {
            return new ConverterRow("NZD", this.NZD);
        }

        public ConverterRow getZAR() {
            return new ConverterRow("ZAR", this.ZAR);
        }

        public ConverterRow getUSD() {
            return new ConverterRow("USD", this.USD);
        }

        public ConverterRow getMXN() {
            return new ConverterRow("MXN", this.MXN);
        }

        public ConverterRow getILS() {
            return new ConverterRow("ILS", this.ILS);
        }

        public ConverterRow getGBP() {
            return new ConverterRow("GBP", this.GBP);
        }

        public ConverterRow getKRW() {
            return new ConverterRow("KRW", this.KRW);
        }

        public ConverterRow getMYR() {
            return new ConverterRow("MYR", this.MYR);
        }
    }

    private Rates rates;

    private String base;

    private String date;

    public ConverterRow getEUR() {
        return new ConverterRow(this.base, (double) 1);
    }

    public String getDate() {
        return this.date;
    }

    public ArrayList<ConverterRow> GetBase() { //ArrayList на случай изменения количества валют в Json ответе, чтобы можно было за несколько строк все обновить
        ArrayList<ConverterRow> Base = new ArrayList<ConverterRow>();//можно было бы не делать этот класс, а обрабатывать Json ответ как строку, но я посчитал, что мне будет так удобнее
        Base.add(getEUR());
        Base.add(rates.getCAD());
        Base.add(rates.getHKD());
        Base.add(rates.getISK());
        Base.add(rates.getPHP());
        Base.add(rates.getDKK());
        Base.add(rates.getHUF());
        Base.add(rates.getCZK());
        Base.add(rates.getAUD());
        Base.add(rates.getRON());
        Base.add(rates.getSEK());
        Base.add(rates.getIDR());
        Base.add(rates.getINR());
        Base.add(rates.getBRL());
        Base.add(rates.getRUB());
        Base.add(rates.getHRK());
        Base.add(rates.getJPY());
        Base.add(rates.getTHB());
        Base.add(rates.getCHF());
        Base.add(rates.getSGD());
        Base.add(rates.getPLN());
        Base.add(rates.getBGN());
        Base.add(rates.getTRY());
        Base.add(rates.getCNY());
        Base.add(rates.getNOK());
        Base.add(rates.getNZD());
        Base.add(rates.getZAR());
        Base.add(rates.getUSD());
        Base.add(rates.getMXN());
        Base.add(rates.getILS());
        Base.add(rates.getGBP());
        Base.add(rates.getKRW());
        Base.add(rates.getMYR());
        return Base;
    }
}
