package utils.dataHelpers;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

import java.util.Locale;

public class PurpleUser {
    public PurpleUser(String firstName, String lastName, String emailAddress, String phoneNumber, String password, String streetAddress1, String streetAddress2, String city, String state, String zipCode, String creditCardNumber, String creditCardExpirationDate, String creditCardSecurityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpirationDate = creditCardExpirationDate;
        this.creditCardSecurityCode = creditCardSecurityCode;
    }

    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;
    public String password;
    public String streetAddress1;
    public String streetAddress2;
    public String city;
    public String state;
    public String zipCode;
    public String creditCardNumber;
    public String creditCardExpirationDate;
    public String creditCardSecurityCode;

    public static PurpleUser getInstance() {
        return new PurpleUser(
                "Test",
                "Automation",
                "purple.test.automation@outlook.com",
                "9999999999",
                "Automation123.",
                "410 N Arlington Heights Rd",
                "apt 1",
                "Arlington Heights",
                "IL",
                "60004",
                "5500000000000004",
                "1126",
                "233"
        );
    }

    public static PurpleUser getRandomInstance() {
        Faker faker = new Faker(new Locale("en-us"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String street1 = faker.address().streetAddress();
        String street2 = "Apt " + faker.address().streetAddressNumber();
        String city = faker.address().city();
        String state = "";
        do {
            state = faker.address().stateAbbr();
        } while (state.equalsIgnoreCase("AK") || state.equalsIgnoreCase("HI"));


        String zipCode = faker.address().zipCodeByState(state);
        String phoneNumber = faker.number().digits(10);
        String password = faker.internet().password(10, 16, true, true, true);
        String creditCardNumber = faker.finance().creditCard(CreditCardType.VISA).replaceAll("-", "");
        String creditCardExpirationDate = "" + faker.number().numberBetween(10, 12) + faker.number().numberBetween(23, 33);
        String creditCardSecurityCode = "" + faker.number().digits(3);

        return new PurpleUser(
                firstName,
                lastName,
                email,
                phoneNumber,
                password,
                street1,
                street2,
                city,
                state,
                zipCode,
                creditCardNumber,
                creditCardExpirationDate,
                creditCardSecurityCode
        );

    }

    public static PurpleUser getRandomInstance(String stateAbb) {
        Faker faker = new Faker(new Locale("en-us"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String street1 = faker.address().streetAddress();
        String street2 = "Apt " + faker.address().streetAddressNumber();
        String city = faker.address().city();

        String zipCode = faker.address().zipCodeByState(stateAbb);
        String phoneNumber = faker.number().digits(10);
        String password = faker.internet().password(10, 16, true, true, true);
        String creditCardNumber = faker.finance().creditCard(CreditCardType.VISA).replaceAll("-", "");
        String creditCardExpirationDate = "" + faker.number().numberBetween(10, 12) + faker.number().numberBetween(23, 33);
        String creditCardSecurityCode = "" + faker.number().digits(3);

        return new PurpleUser(
                firstName,
                lastName,
                email,
                phoneNumber,
                password,
                street1,
                street2,
                city,
                stateAbb,
                zipCode,
                creditCardNumber,
                creditCardExpirationDate,
                creditCardSecurityCode
        );

    }

    @Override
    public String toString() {
        return "PurpleUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", streetAddress1='" + streetAddress1 + '\'' +
                ", streetAddress2='" + streetAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardExpirationDate='" + creditCardExpirationDate + '\'' +
                ", creditCardSecurityCode='" + creditCardSecurityCode + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(getRandomInstance("CA"));
        System.out.println(getRandomInstance("CT"));
        System.out.println(getRandomInstance("CO"));
        System.out.println(getRandomInstance("RI"));
    }
}
