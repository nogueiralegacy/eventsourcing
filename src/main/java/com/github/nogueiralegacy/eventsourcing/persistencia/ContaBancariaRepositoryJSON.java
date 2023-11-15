package com.github.nogueiralegacy.eventsourcing.persistencia;

import com.github.nogueiralegacy.eventsourcing.domain.ContaBancaria;
import com.github.nogueiralegacy.eventsourcing.domain.repository.ContaBancariaRepository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Paths;
import java.util.Optional;

public class ContaBancariaRepositoryJSON implements ContaBancariaRepository {
    private static final String DIR_PERSISTENCIA = SetUp.getDirPersistencia();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void save(ContaBancaria contaBancaria) {
        String fileName = Paths.get(DIR_PERSISTENCIA, contaBancaria.getCPF() + ".json").toString();

        String contaBancariaJson = gson.toJson(contaBancaria);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(contaBancariaJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<ContaBancaria> findByCPF(String cpf) {
        String fileName = Paths.get(DIR_PERSISTENCIA, cpf + ".json").toString();

        ContaBancaria contaBancaria = null;

        File file = new File(fileName);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                contaBancaria = gson.fromJson(reader, ContaBancaria.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Optional.ofNullable(contaBancaria);
    }

}
