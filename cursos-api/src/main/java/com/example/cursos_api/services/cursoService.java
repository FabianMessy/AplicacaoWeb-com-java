package com.example.cursos_api.services;

import org.springframework.stereotype.Service;
import com.example.cursos_api.models.cursoModel;
import com.example.cursos_api.repository.cursoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class cursoService {
    private final cursoRepository repository;

    public cursoService(cursoRepository repository){this.repository=repository;}

    public List<cursoModel> listarall(){return repository.findAll();}

    public Optional<cursoModel> searchporID (Long id) {return repository.findById(id);}

    public cursoModel salvar(cursoModel curso){
        return repository.save(curso);
    }

    public Optional<cursoModel> atualizar(Long id, cursoModel dados){
        // busca o curso pelo id, optionalCurso é uma variavel do tipo Optional q pode ter um valor nulo ou do tipo <cursoModel>
        Optional<cursoModel> optionalCurso = repository.findById(id);

        cursoModel cursoencontrado=optionalCurso.get();

        //boolean e dps att
        if (optionalCurso.isPresent()) {
            cursoModel curso = optionalCurso.get();
            curso.setNome(dados.getNome());
            curso.setCategoria(dados.getCategoria());
            curso.setCargaHoraria(dados.getCargaHoraria());

        

        cursoModel cursoatt=repository.save(cursoencontrado);

        return Optional.of(cursoatt);
        }
        return Optional.empty();
    }

    public boolean deletar(Long id){
        //o ! troca o boolean para o inverso
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
