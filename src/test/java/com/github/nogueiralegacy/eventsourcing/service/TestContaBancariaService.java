package com.github.nogueiralegacy.eventsourcing.service;

import com.github.nogueiralegacy.eventsourcing.domain.ContaBancaria;
import com.github.nogueiralegacy.eventsourcing.persistencia.SetUp;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestContaBancariaService {
    private static final String DIR_PERSISTENCIA = SetUp.getDirPersistencia();
    private final ContaBancariaService contaBancariaService = new ContaBancariaService();


    @Test
    void saveContaBancaria() {
        String filePath = Paths.get(DIR_PERSISTENCIA, "111.222.333-44.json").toString();
        File file = new File(filePath);
        file.delete();

        ContaBancaria contaBancaria = new ContaBancaria("111.222.333-44");
        contaBancariaService.save(contaBancaria);


        assertTrue(file.exists());
        file.delete();
    }

    @Test
    void testFindByCPF() {
        String filePath = Paths.get(DIR_PERSISTENCIA, "111.222.333-44.json").toString();
        File file = new File(filePath);
        file.delete();

        ContaBancaria contaBancaria = new ContaBancaria("111.222.333-44");
        contaBancariaService.save(contaBancaria);

        assertEquals("111.222.333-44", contaBancariaService.findByCPF("111.222.333-44").getCPF());
        file.delete();
    }

    @Test
    void testSaldo() {
        String filePath = Paths.get(DIR_PERSISTENCIA, "111.222.333-44.json").toString();
        File file = new File(filePath);
        file.delete();

        ContaBancaria contaBancaria = new ContaBancaria("111.222.333-44");
        contaBancaria.creditar(100);

        contaBancariaService.save(contaBancaria);

        assertEquals(100, contaBancaria.getSaldo());
    }
}
