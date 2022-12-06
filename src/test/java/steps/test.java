package steps;

import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;

public class test {
    public static void main(String[] args) {
        Faker faker = Faker.instance();

//        System.out.println(faker.address().fullAddress());
//        System.out.println(faker.name().fullName());
//        System.out.println(faker.phoneNumber().cellPhone());
//        System.out.println(faker.address().city());
//        System.out.println(faker.address().streetAddress());
//        System.out.println(faker.address().state());
//        System.out.println(faker.address().zipCode());
//        System.out.println(faker.address().fullAddress());
//
//        String[] fullAddressArr = faker.address().fullAddress().split(",");
//        String street1 = fullAddressArr[0];
//        String city = fullAddressArr[1].trim();
//        String state = fullAddressArr[2].trim().substring(0, fullAddressArr[2].trim().indexOf(" "));
//        String zip = fullAddressArr[2].trim().substring(fullAddressArr[2].trim().indexOf(" ")).trim();
//
//        System.out.println(Arrays.toString(fullAddressArr));
//        System.out.println(street1);
//        System.out.println(city);
//        System.out.println(state);
//        System.out.println(zip);
//
//        System.out.println(new Faker(new Locale("en-US")).address().fullAddress());

        System.out.println(Faker.instance().number().numberBetween(0,5));
    }
}
