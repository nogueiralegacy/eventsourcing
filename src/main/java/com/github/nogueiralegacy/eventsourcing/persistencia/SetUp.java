package com.github.nogueiralegacy.eventsourcing.persistencia;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class SetUp {
    private final static String USER_HOME = System.getProperty("user.home");
    private final static String DIR_PERSISTENCIA = Paths.get(USER_HOME, ".eventsourcing").toString();

    static {
        criaDiretorio(DIR_PERSISTENCIA);
    }

    public static void criaDiretorio(String dir) {
        File diretorioProjeto = new File(dir);

        if (!diretorioProjeto.exists()) {
            // Tenta criar o diretório
            if (diretorioProjeto.mkdir()) {
                System.out.println("Diretório criado com sucesso: " + dir);
            } else {
                System.out.println("Erro ao criar o diretório" + dir);
                criaDiretorio(receberDiretorio());
            }
        }
    }

    private static String receberDiretorio() {
        System.out.println("Informe o diretório para persistência dos dados: ");
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }

    public static String getDirPersistencia() {
        return DIR_PERSISTENCIA;
    }
}


