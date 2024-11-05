package br.com.senai.lista_de_tarefas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tarefa {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    private Long id;
    private String nome;
    private String status;
}
