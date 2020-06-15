package com.example.converter2

import java.util.*

class ResponceModel {
    inner class Rates {
        var CAD = 0.0
        var HKD = 0.0
        var ISK = 0.0
        var PHP = 0.0
        var DKK = 0.0
        var HUF = 0.0
        var CZK = 0.0
        var AUD = 0.0
        var RON = 0.0
        var SEK = 0.0
        var IDR = 0.0
        var INR = 0.0
        var BRL = 0.0
        var RUB = 0.0
        var HRK = 0.0
        var JPY = 0.0
        var THB = 0.0
        var CHF = 0.0
        var SGD = 0.0
        var PLN = 0.0
        var BGN = 0.0
        var TRY = 0.0
        var CNY = 0.0
        var NOK = 0.0
        var NZD = 0.0
        var ZAR = 0.0
        var USD = 0.0
        var MXN = 0.0
        var ILS = 0.0
        var GBP = 0.0
        var KRW = 0.0
        var MYR = 0.0
        fun getCAD(): ConverterRow {
            return ConverterRow("CAD", CAD);
        }

        fun getHKD(): ConverterRow {
            return ConverterRow("HKD", HKD);
        }

        fun getISK(): ConverterRow {
            return ConverterRow("ISK", ISK);
        }

        fun getPHP(): ConverterRow {
            return ConverterRow("PHP", PHP);
        }

        fun getDKK(): ConverterRow {
            return ConverterRow("DKK", DKK);
        }

        fun getHUF(): ConverterRow {
            return ConverterRow("HUF", HUF);
        }

        fun getCZK(): ConverterRow {
            return ConverterRow("CZK", CZK);
        }

        fun getAUD(): ConverterRow {
            return ConverterRow("AUD", AUD);
        }

        fun getRON(): ConverterRow {
            return ConverterRow("RON", RON);
        }

        fun getSEK(): ConverterRow {
            return ConverterRow("SEK", SEK);
        }

        fun getIDR(): ConverterRow {
            return ConverterRow("IDR", IDR);
        }

        fun getINR(): ConverterRow {
            return ConverterRow("INR", INR);
        }

        fun getBRL(): ConverterRow {
            return ConverterRow("BRL", BRL);
        }

        fun getRUB(): ConverterRow {
            return ConverterRow("RUB", RUB);
        }

        fun getHRK(): ConverterRow {
            return ConverterRow("HRK", HRK);
        }

        fun getJPY(): ConverterRow {
            return ConverterRow("JPY", JPY);
        }

        fun getTHB(): ConverterRow {
            return ConverterRow("THB", THB);
        }

        fun getCHF(): ConverterRow {
            return ConverterRow("CHF", CHF);
        }

        fun getSGD(): ConverterRow {
            return ConverterRow("SGD", SGD);
        }

        fun getPLN(): ConverterRow {
            return ConverterRow("PLN", PLN);
        }

        fun getBGN(): ConverterRow {
            return ConverterRow("BGN", BGN);
        }

        fun getTRY(): ConverterRow {
            return ConverterRow("TRY", TRY);
        }

        fun getCNY(): ConverterRow {
            return ConverterRow("CNY", CNY);
        }

        fun getNOK(): ConverterRow {
            return ConverterRow("NOK", NOK);
        }

        fun getNZD(): ConverterRow {
            return ConverterRow("NZD", NZD);
        }

        fun getZAR(): ConverterRow {
            return ConverterRow("ZAR", ZAR);
        }

        fun getUSD(): ConverterRow {
            return ConverterRow("USD", USD);
        }

        fun getMXN(): ConverterRow {
            return ConverterRow("MXN", MXN);
        }

        fun getILS(): ConverterRow {
            return ConverterRow("ILS", ILS);
        }

        fun getGBP(): ConverterRow {
            return ConverterRow("GBP", GBP);
        }

        fun getKRW(): ConverterRow {
            return ConverterRow("KRW", KRW);
        }

        fun getMYR(): ConverterRow {
            return ConverterRow("MYR", MYR);
        }

    }

    private var rates: Rates? = null
    private var base: String? = null
    var date: String? = null
    get() = date;
    fun getEUR():ConverterRow{ return ConverterRow(base!!, 1.toDouble())}

    fun GetBase(): ArrayList<ConverterRow> { //ArrayList на случай изменения количества валют в Json ответе, чтобы можно было за несколько строк все обновить
        val Base = ArrayList<ConverterRow>() //можно было бы не делать этот класс, а обрабатывать Json ответ как строку, но я посчитал, что мне будет так удобнее
        Base.add(getEUR())
        Base.add(rates!!.getCAD())
        Base.add(rates!!.getHKD())
        Base.add(rates!!.getISK())
        Base.add(rates!!.getPHP())
        Base.add(rates!!.getDKK())
        Base.add(rates!!.getHUF())
        Base.add(rates!!.getCZK())
        Base.add(rates!!.getAUD())
        Base.add(rates!!.getRON())
        Base.add(rates!!.getSEK())
        Base.add(rates!!.getIDR())
        Base.add(rates!!.getINR())
        Base.add(rates!!.getBRL())
        Base.add(rates!!.getRUB())
        Base.add(rates!!.getHRK())
        Base.add(rates!!.getJPY())
        Base.add(rates!!.getTHB())
        Base.add(rates!!.getCHF())
        Base.add(rates!!.getSGD())
        Base.add(rates!!.getPLN())
        Base.add(rates!!.getBGN())
        Base.add(rates!!.getTRY())
        Base.add(rates!!.getCNY())
        Base.add(rates!!.getNOK())
        Base.add(rates!!.getNZD())
        Base.add(rates!!.getZAR())
        Base.add(rates!!.getUSD())
        Base.add(rates!!.getMXN())
        Base.add(rates!!.getILS())
        Base.add(rates!!.getGBP())
        Base.add(rates!!.getKRW())
        Base.add(rates!!.getMYR())
        return Base
    }
}
