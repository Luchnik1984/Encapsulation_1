package org.skypro.skyshop.exeptions;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Объект по запросу '" + search + "' не найден");
    }
}
