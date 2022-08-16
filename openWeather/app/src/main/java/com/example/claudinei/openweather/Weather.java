package com.example.claudinei.openweather;

public class Weather {
    private String tempMax;
    private String tempMin;
    private String tempAtual;
    private String umidade;

    public Weather() {
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempAtual() {
        return tempAtual;
    }

    public void setTempAtual(String tempAtual) {
        this.tempAtual = tempAtual;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    @Override
    public String toString(){
        return "Temperatura Atual = " + tempAtual + "°C\nTemperatura Mínima = " + tempMin
        + "°C\nTemperatura Máxima = " + tempMax + "°C\nUmidade = " + umidade + "%";
    }
}
