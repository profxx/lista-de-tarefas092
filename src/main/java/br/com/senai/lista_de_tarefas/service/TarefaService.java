package br.com.senai.lista_de_tarefas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.lista_de_tarefas.entity.Tarefa;
import br.com.senai.lista_de_tarefas.repository.TarefaRepository;

@Service
public class TarefaService {
    
    @Autowired
    private TarefaRepository tarefaRepository;

    // Listar todas as tarefas
    public List<Tarefa> findAll(){
        return tarefaRepository.findAll();
    }
    // Mostrar uma tarefa pelo ID
    public Tarefa findById(Long id){
        return tarefaRepository.findById(id).orElse(null);
    }
    // Inserir nova tarefa
    public Tarefa insertNew(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    // Alterar uma tarefa existente
    public Tarefa update(Long id, Tarefa tarefaAlterada){
        Tarefa tarefa = findById(id);
        tarefa.setNome(tarefaAlterada.getNome());
        tarefa.setStatus(tarefaAlterada.getStatus());
        return tarefaRepository.save(tarefa);
    }
    // Apagar uma tarefa
    public Boolean deleteById(Long id){
        Tarefa tarefa = findById(id);
        if (tarefa == null){
            return false;
        }else{
            tarefaRepository.deleteById(id);
            return true;
        }
    }

}
