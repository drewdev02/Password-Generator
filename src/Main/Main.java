package Main;

import CardCenter.Card;
import CardCenter.MatrixCard;
import CardCenter.PartnerCard;
import CardCenter.PrivateCard;
import GUI.GUI;
import Login.Login;

import java.net.URI;
import java.security.KeyStore;
import java.time.YearMonth;
import java.util.ArrayList;

public class Main {
    Login login;
    PrivateCard privateCard;
    ArrayList<Login> loginArrayList = new ArrayList<>();
    ArrayList<Card> cardArrayList = new ArrayList<>();
    ArrayList<MatrixCard> matrixCards = new ArrayList<>();

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.StartGUI();
    }

    public String validatePrivateCard(Card.CardType cardType, String alias, Card.Brand brand, String cardHolderName, String cardNumber, Card.Currency currency, String cashierPin, String telePin, YearMonth expirationDate, MatrixCard matrix) {
        String message = "Tarjeta agregada con éxito";
        boolean pass = true;
        char[] cardHolderNameArray = new char[cardHolderName.length()];

        //converting CardHolderName to a char Array
        for (int i = 0; i < cardHolderName.length(); i++) {
            String letter = null;
            cardHolderNameArray[i] = cardHolderName.charAt(i);
            letter = String.valueOf(cardHolderNameArray[i]);
            boolean containletter = true;
            if (!letter.matches("[a-zA-Z]")) {
                pass = false;
                message = "Error al agregar. Por favor, rectifique el nombre";
                System.out.println(letter + ":no cointain letter");
                break;
            }
        }

/*
        if (alias.length() > 20) {
            message = "Introduzca un alias más corto.";
            pass = false;
        }//checks if alias contains more than 20 chars
        else if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            message = "Proporcione 16 números para su tarjeta.";
            pass = false;
        }//checks if card number contain more or less than 16 numbers
        else if (cashierPin.length() != 4) {
            message = "Introduzca un pin de 4 dígitos";
            pass = false;
        }//checks if the length of cashier pin is different that 4
        else if (!cashierPin.matches("\\d+") || !telePin.matches("\\d+")) {
            message = "El pin solo debe contener números";
            pass = false;
        }//checks if pin for cashier and pi for tele-operations ocontains chars differents than numbers
        else if (cardHolderName.matches("[a-zA-Z]+")) {
            message = "Ha introducido un nombre no válido por favor verifique.";
            pass = false;
        }/*DOOT WORK  Cheks if cardholder name contains chars unallowed
        else if (brand.equals(Card.Brand.BANDEC)) {
            if (telePin.length() != 5) {
                message = "Pin de transfermóvil incorrecto, por favor introduzca 5 dígitos";
                pass = false;
            }

        }//checks if the length for transfremovil pin of BANDEC cards is different from 5
        else if (cardHolderName.split("\\s").length > 4 || cardHolderName.split("\\s").length < 3) {
            message = "Ha introducido un nombre no válido por favor verifique(cantidad de letras).";
            pass = false;
        }// check how many words contain thee crdholder name if it contain less than 3 or more than 4 app will show error
        else if (brand.equals(Card.Brand.BPA) || brand.equals(Card.Brand.METROPOLITANO)) {
            if (telePin.length() != 4) {
                message = "Pin de transfermóvil incorrecto, por favor introduzca 4 dígitos";
                pass = false;
            }
        }//checks if the length for transfremovil pin of METROPOLITANO and BPA cards is different from 4
        else if (brand.equals(Card.Brand.MASTERDCARD) || brand.equals(Card.Brand.VISA) || brand.equals(Card.Brand.OTHER))

            if (brand.equals(Card.Brand.MASTERDCARD) || brand.equals(Card.Brand.VISA)) {
                if (currency.equals(Card.Currency.MLC) || currency.equals(Card.Currency.CUP)) {
                    message = "Modena no válida para esta tarjeta.";
                    pass = false;
                }
            } //if card belongs to MASTERCARD or VISA app won't let set currency as MLC OR CUP
            else if (brand.equals(Card.Brand.METROPOLITANO) || brand.equals(Card.Brand.BANDEC) || brand.equals(Card.Brand.BPA)) {
                if (currency.equals(Card.Currency.OTHER) || currency.equals(Card.Currency.USD) || currency.equals(Card.Currency.EUR)) {
                    message = "Modena no válida para esta tarjeta.";
                    pass = false;
                }
            }//if card belongs to METROPOLITANO, BANDEC or BPA we won't be able to set currency as USD, EUR or OTHER
*/
        if (pass == true) {
            privateCard = new PrivateCard(cardType, alias, brand, cardHolderName, cardNumber, currency, cashierPin, telePin, expirationDate, matrix);
            savePrivateCard(privateCard);
            System.out.println(
                    "\nTarjeta: " + cardType +
                            "\nAlias: " + alias +
                            "\nTipo: " + brand +
                            "\nNombre del Propietario: " + cardHolderName +
                            "\nNúmero de tarjeta: " + cardNumber +
                            "\nMoneda: " + currency +
                            "\nPin de cajero automatico: " + cashierPin +
                            "\nPin de transfermovil: " + telePin +
                            "\nFecha de expiracion: " + expirationDate +
                            "\nMatrix asosiada: " + matrix +
                            "\n");
        }
        return message;
    }//validating info of a private card before be aded

    public void checkPartnerCard() {
    }

    public void checkMatrixCard() {
    }

    public void saveLogin(String ID, String UserName, KeyStore.PasswordProtection Password, URI URL, String Notes) {
        login = new Login(ID, UserName, Password, URL, Notes);
        loginArrayList.add(login);
    }//funtion for adding a new login item to the array, usesrs will be able to save login information like Name, username, URL, password and extra notes

    public void savePrivateCard(PrivateCard privateCard) {
        cardArrayList.add(privateCard);
    }//method for saving private cards to array

    public void savePartnerCard(PartnerCard partnerCard) {
        cardArrayList.add(partnerCard);

    }//method for saving partner cards to array

    public void saveMatrixCArd(MatrixCard matrixCard) {
        matrixCards.add(matrixCard);
    }//for saving matrix cards into arraylist

}
