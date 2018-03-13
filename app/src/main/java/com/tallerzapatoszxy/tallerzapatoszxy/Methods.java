package com.tallerzapatoszxy.tallerzapatoszxy;

import android.content.res.Resources;

import java.text.NumberFormat;

public class Methods {

    public static double calculatePrice(double price, double cant){
        double result = price * cant;

        return result;
    }

    public static double getShoesValueFromCharacteristics(int selectedGender, int selectedShoeType, int selectedBrand, double cant) {
        double totalValue = 0;

        switch (selectedGender) {
            case 0: // For Men
                switch (selectedShoeType) {
                    case 0: // For sneaker
                        switch (selectedBrand) {
                            case 0: // For Nike
                                totalValue = Methods.calculatePrice(120000, cant);
                                break;
                            case 1: // For adidas
                                totalValue = Methods.calculatePrice(140000, cant);
                                break;
                            case 2: // For puma
                                totalValue = Methods.calculatePrice(130000, cant);
                                break;
                        }

                        break;
                    case 1: // For classic
                        switch (selectedBrand) {
                            case 0: // For Nike
                                totalValue = Methods.calculatePrice(50000, cant);
                                break;
                            case 1: // For adidas
                                totalValue = Methods.calculatePrice(80000, cant);
                                break;
                            case 2: // For puma
                                totalValue = Methods.calculatePrice(100000, cant);
                                break;
                        }

                        break;
                }

                break;
            case 1: // For women
                switch (selectedShoeType) {
                    case 0: // For sneaker
                        switch (selectedBrand) {
                            case 0: // For Nike
                                totalValue = Methods.calculatePrice(100000, cant);
                                break;
                            case 1: // For adidas
                                totalValue = Methods.calculatePrice(130000, cant);
                                break;
                            case 2: // For puma
                                totalValue = Methods.calculatePrice(110000, cant);
                                break;
                        }

                        break;
                    case 1: // For classic
                        switch (selectedBrand) {
                            case 0: // For Nike
                                totalValue = Methods.calculatePrice(60000, cant);
                                break;
                            case 1: // For adidas
                                totalValue = Methods.calculatePrice(70000, cant);
                                break;
                            case 2: // For puma
                                totalValue = Methods.calculatePrice(120000, cant);
                                break;
                        }

                        break;
                }

                break;
        }
        return totalValue;
    }
}
