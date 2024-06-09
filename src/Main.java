import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1Java = new Curso();
        curso1Java.setTitulo("fundamentos java");
        curso1Java.setDescricao("descrição curso java");
        curso1Java.setCargaHoraria(8);

        Curso curso2Java = new Curso();
        curso2Java.setTitulo("curso POO");
        curso2Java.setDescricao("descrição curso POO");
        curso2Java.setCargaHoraria(6);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("mentoria de java");
        mentoriaJava.setDescricao("descrição mentoria java");
        mentoriaJava.setData(LocalDate.now());
        
        
        Curso curso1Python = new Curso();
        curso1Python.setTitulo("fundamentos python");
        curso1Python.setDescricao("descrição curso python");
        curso1Python.setCargaHoraria(8);
        
        Curso curso2Python = new Curso();
        curso2Python.setTitulo("curso automação");
        curso2Python.setDescricao("descrição curso automação");
        curso2Python.setCargaHoraria(5);
        
        Mentoria mentoriaPython = new Mentoria();
        mentoriaPython.setTitulo("mentoria de python");
        mentoriaPython.setDescricao("descrição mentoria python");
        mentoriaPython.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcampJava = new Bootcamp("Bootcamp Java Developer");
        bootcampJava.setDescricao("Descrição Bootcamp Java Developer");
        bootcampJava.getConteudos().add(curso1Java);
        bootcampJava.getConteudos().add(curso2Java);
        bootcampJava.getConteudos().add(mentoriaJava);
        
        Bootcamp bootcampPython = new Bootcamp("Bootcamp Python Developer");
        bootcampPython.setDescricao("Descrição Bootcamp Python Developer");
        bootcampPython.getConteudos().add(curso1Python);
        bootcampPython.getConteudos().add(curso2Python);
        bootcampPython.getConteudos().add(mentoriaPython);

        Dev devCamila = new Dev("Camila");
        devCamila.inscreverBootcamp(bootcampJava);
        devCamila.inscreverBootcamp(bootcampPython);
        System.out.println("Bootcamps Inscritos Camila:" + devCamila.getBootcampsInscritos());
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        devCamila.progredir(bootcampJava);
        devCamila.progredir(bootcampJava);
        devCamila.progredir(bootcampPython);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev("Joao");
        devJoao.inscreverBootcamp(bootcampJava);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        devJoao.progredir(bootcampJava);
        devJoao.progredir(bootcampJava);
        devJoao.progredir(bootcampJava);
        devJoao.progredir(bootcampJava);
        System.out.println("-");
        System.out.println("Bootcamps Inscritos João:" + devJoao.getBootcampsInscritos());
        System.out.println("Bootcamps Concluidos Joao:" + devJoao.getBootcampsConcluidos());
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("XP:" + devJoao.calcularTotalXp());
        
        
        Dev devWericson = new Dev("Wericson");
        devWericson.inscreverBootcamp(bootcampJava);
        devWericson.inscreverBootcamp(bootcampPython);
        System.out.println("Conteúdos Inscritos Wericson:" + devWericson.getConteudosInscritos());
        devWericson.progredir(bootcampJava);
        devWericson.progredir(bootcampJava);
        devWericson.progredir(bootcampPython);
        devWericson.progredir(bootcampPython);
        devWericson.progredir(bootcampPython);
        System.out.println("-");
        System.out.println("Bootcamps Inscritos Wericson:" + devWericson.getBootcampsInscritos());
        System.out.println("Bootcamps Concluidos Wericson:" + devWericson.getBootcampsConcluidos());
        System.out.println("Conteúdos Inscritos Wericson:" + devWericson.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Wericson:" + devWericson.getConteudosConcluidos());
        System.out.println("XP:" + devWericson.calcularTotalXp());

    }

}
