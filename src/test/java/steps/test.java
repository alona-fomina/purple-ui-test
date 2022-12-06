package steps;

import com.github.javafaker.Faker;

public class test {
    public static void main(String[] args) {
        Faker faker = Faker.instance();
        System.out.println(faker.name().fullName());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.address().city());
        System.out.println(faker.address().streetAddress());
        System.out.println(faker.address().state());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.address().fullAddress());


    }
}
