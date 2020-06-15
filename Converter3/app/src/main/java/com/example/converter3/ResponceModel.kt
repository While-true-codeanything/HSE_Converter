package com.example.converter3


class ResponceModel(
    private var rates: Rates,
    private var base: String,
    date: String
) {
    inner class Rates(
        private var CAD: Double,
        private var HKD: Double,
        private var ISK: Double,
        private var PHP: Double,
        private var DKK: Double,
        private var HUF: Double,
        private var CZK: Double,
        private var AUD: Double,
        private var RON: Double,
        private var SEK: Double,
        private var IDR: Double,
        private var INR: Double,
        private var BRL: Double,
        private var RUB: Double,
        private var HRK: Double,
        private var JPY: Double,
        private var THB: Double,
        private var CHF: Double,
        private var SGD: Double,
        private var PLN: Double,
        private var BGN: Double,
        private var TRY: Double,
        private var CNY: Double,
        private var NOK: Double,
        private var NZD: Double,
        private var ZAR: Double,
        private var USD: Double,
        private var MXN: Double,
        private var ILS: Double,
        private var GBP: Double,
        private var KRW: Double,
        private var MYR: Double
    ) {
        fun getCAD(): ConverterRow {
            return ConverterRow("CAD", CAD)
        }

        fun getHKD(): ConverterRow {
            return ConverterRow("HKD", HKD)
        }

        fun getISK(): ConverterRow {
            return ConverterRow("ISK", ISK)
        }

        fun getPHP(): ConverterRow {
            return ConverterRow("PHP", PHP)
        }

        fun getDKK(): ConverterRow {
            return ConverterRow("DKK", DKK)
        }

        fun getHUF(): ConverterRow {
            return ConverterRow("HUF", HUF)
        }

        fun getCZK(): ConverterRow {
            return ConverterRow("CZK", CZK)
        }

        fun getAUD(): ConverterRow {
            return ConverterRow("AUD", AUD)
        }

        fun getRON(): ConverterRow {
            return ConverterRow("RON", RON)
        }

        fun getSEK(): ConverterRow {
            return ConverterRow("SEK", SEK)
        }

        fun getIDR(): ConverterRow {
            return ConverterRow("IDR", IDR)
        }

        fun getINR(): ConverterRow {
            return ConverterRow("INR", INR)
        }

        fun getBRL(): ConverterRow {
            return ConverterRow("BRL", BRL)
        }

        fun getRUB(): ConverterRow {
            return ConverterRow("RUB", RUB)
        }

        fun getHRK(): ConverterRow {
            return ConverterRow("HRK", HRK)
        }

        fun getJPY(): ConverterRow {
            return ConverterRow("JPY", JPY)
        }

        fun getTHB(): ConverterRow {
            return ConverterRow("THB", THB)
        }

        fun getCHF(): ConverterRow {
            return ConverterRow("CHF", CHF)
        }

        fun getSGD(): ConverterRow {
            return ConverterRow("SGD", SGD)
        }

        fun getPLN(): ConverterRow {
            return ConverterRow("PLN", PLN)
        }

        fun getBGN(): ConverterRow {
            return ConverterRow("BGN", BGN)
        }

        fun getTRY(): ConverterRow {
            return ConverterRow("TRY", TRY)
        }

        fun getCNY(): ConverterRow {
            return ConverterRow("CNY", CNY)
        }

        fun getNOK(): ConverterRow {
            return ConverterRow("NOK", NOK)
        }

        fun getNZD(): ConverterRow {
            return ConverterRow("NZD", NZD)
        }

        fun getZAR(): ConverterRow {
            return ConverterRow("ZAR", ZAR)
        }

        fun getUSD(): ConverterRow {
            return ConverterRow("USD", USD)
        }

        fun getMXN(): ConverterRow {
            return ConverterRow("MXN", MXN)
        }

        fun getILS(): ConverterRow {
            return ConverterRow("ILS", ILS)
        }

        fun getGBP(): ConverterRow {
            return ConverterRow("GBP", GBP)
        }

        fun getKRW(): ConverterRow {
            return ConverterRow("KRW", KRW)
        }

        fun getMYR(): ConverterRow {
            return ConverterRow("MYR", MYR)
        }

    }

    var date: String = date
        get() = field

    private fun getEUR(): ConverterRow {
        return ConverterRow(base, 1.toDouble())
    }

    fun GetBase(): ArrayList<ConverterRow> { //ArrayList на случай изменения количества валют в Json ответе, чтобы можно было за несколько строк все обновить
        val Base =
            ArrayList<ConverterRow>() //можно было бы не делать этот класс, а обрабатывать Json ответ как строку, но я посчитал, что мне будет так удобнее
        Base.add(getEUR())
        Base.add(rates.getCAD())
        Base.add(rates.getHKD())
        Base.add(rates.getISK())
        Base.add(rates.getPHP())
        Base.add(rates.getDKK())
        Base.add(rates.getHUF())
        Base.add(rates.getCZK())
        Base.add(rates.getAUD())
        Base.add(rates.getRON())
        Base.add(rates.getSEK())
        Base.add(rates.getIDR())
        Base.add(rates.getINR())
        Base.add(rates.getBRL())
        Base.add(rates.getRUB())
        Base.add(rates.getHRK())
        Base.add(rates.getJPY())
        Base.add(rates.getTHB())
        Base.add(rates.getCHF())
        Base.add(rates.getSGD())
        Base.add(rates.getPLN())
        Base.add(rates.getBGN())
        Base.add(rates.getTRY())
        Base.add(rates.getCNY())
        Base.add(rates.getNOK())
        Base.add(rates.getNZD())
        Base.add(rates.getZAR())
        Base.add(rates.getUSD())
        Base.add(rates.getMXN())
        Base.add(rates.getILS())
        Base.add(rates.getGBP())
        Base.add(rates.getKRW())
        Base.add(rates.getMYR())
        return Base
    }
}
