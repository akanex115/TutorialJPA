package com.techacademy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    // 全件を検索して返す
    public List<Country> getCountryList() {
        // リポジトリのfindAllメソッドを呼び出す
        return repository.findAll();
    }

    public Country getCoutntry(String code) {
        Optional<Country> option = repository.findById(code);
        //取得できなかった場合はnullを返す
        Country country = option.orElse(null);
        return country;
    }

    //更新（追加）
    @Transactional
    public void updateCountry(String code, String name, int poplation) {
        Country country = new Country(code, name, poplation);
        repository.save(country);
    }

    //削除
    @Transactional
    public void deleteCountry(String code) {
        repository.deleteById(code);
    }

}