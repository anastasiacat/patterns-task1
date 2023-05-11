package ru.netology;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String dateGeneration(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String cityGeneration() {
        var cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород",
                "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Горно-Алтайск", "Грозный", "Екатеринбург",
                "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово",
                "Киров", "Кострома", "Краснодар", "Красноярск", "Курск", "Курган", "Кызыл", "Липецк",
                "Майкоп", "Магадан", "Магас", "Махачкала", "Москва", "Мурманск", "Нальчик", "Нарьян-Мар",
                "Нижний Новгород", "Новосибирск", "Омск", "Оренбург", "Орёл", "Пенза", "Пермь", "Петрозаводск",
                "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Санкт-Петербург", "Салехард",
                "Самара", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь",
                "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа",
                "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Черкесск", "Чита", "Элиста",
                "Южно-Сахалинск", "Ярославль", "Якутск"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String nameGeneration(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String phoneGeneration(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo userGeneration(String locale) {
            return new UserInfo(cityGeneration(), nameGeneration(locale), phoneGeneration(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
