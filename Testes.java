package Projeto;
import java.io.IOException;
import java.util.*;

public class Testes {
    public static void main(String[] args) {
            //BD
            testarAdicionarEListarArtigos();
            testarAdicionarEListarAutores();
            testarProcurarArtigoPorTitulo();
            testarProcurarAutorPorID();
            testarEditarArtigo();
            testarEditarAutor();
            testarRemoverAutor();
            testarArtigosAutorPorPeriodo();
            testarNaoVisualizadoDescarregadoPorPeriodo();
            testarTop3();
            testarValidarConsistencia();
            testarRelatorio();
            //GRAFOS
            testarAdicionarAutor();
            testarAdicionarArtigo();
            testarAdicionarCitacoes();
            testarNumeroCitacoesDePrimeiraOrdem();
            testarNumeroCitacoesDeSegundaOrdem();
            testarNumeroAutocitacoes();
            testarSubgrafoPorTipo();
            testarConexo();
            testarListarColaboradores();
            testarNumeroColaboradores();
            testarNumeroArtigosEntreAutores();
            testarSubGrafoPorFiliacao();
    }

    //Base de Dados
    public static void testarAdicionarEListarArtigos() {
            BaseDeDados bd = new BaseDeDados();

            Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
            Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");

            List<String> palavrasChave = Arrays.asList("POO", "Java");
            Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
            Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
            artigo1.adicionarAutor(autor1);
            artigo1.adicionarAutor(autor2);
            artigo2.adicionarAutor(autor1);

            bd.adicionarArtigo(artigo1);
            bd.adicionarArtigo(artigo2);

            System.out.println("Teste Adicionar e Listar Artigos:");
            for (Artigo artigo : bd.listarArtigos()) {
                    System.out.println(artigo.getTitulo());
            }
    }
    public static void testarAdicionarEListarAutores() {
            BaseDeDados bd = new BaseDeDados();

            Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
            Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
            Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
            bd.adicionarAutor(autor1);
            bd.adicionarAutor(autor2);
            bd.adicionarAutor(autor3);

            System.out.println("Teste Adicionar e Listar Autores:");
            for (Autor autor : bd.listarAutores()) {
                    System.out.println(autor.getNome());
            }
    }

        public static void testarProcurarArtigoPorTitulo() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Procurar Artigo Por Titulo");
                System.out.println(bd.procurarArtigoPorTitulo("POO em Java"));
        }

        public static void testarProcurarAutorPorID() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Procurar Autores por ID");
                System.out.println("Procurar por ORCID '1234-5678-9123-4567': " + bd.procurarAutorPorID("1234-5678-9123-4567"));
        }

        public static void testarEditarAutor() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Editar Autor");

                Autor autorEditado = new Autor("Gonçalo Castro", "Castro", "Universidade De Aveiro", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                bd.editarAutor("1234-5678-9123-4567", autorEditado);
                System.out.println("Lista de autores após edição: " + bd.listarAutores());
        }

        public static void testarEditarArtigo() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Editar Artigo");

                Artigo artigoEditado = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2.0", TipoPublicacao.Conferencia, new Date(124,2,23));
                bd.editarArtigo("POO avançada", artigoEditado);
                System.out.println("Lista de artigos após edição: " + bd.listarArtigos());

        }


        public static void testarRemoverAutor() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Remover Autor");

                bd.removerAutor("1234-5678-9123-4567");
                System.out.println("Lista de autores após remoção: " + bd.listarAutores());

        }
        public static void testarArtigosAutorPorPeriodo() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Artigos Autor Por Periodo");

                System.out.println("Lista Artigos Autor Por Periodo: " + bd.artigosAutorPorPeriodo(autor1.getOrcid(),new Date(124,3,30),new Date(124,7,17)));

        }
        public static void testarNaoVisualizadoDescarregadoPorPeriodo() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                Artigo artigo3 = new Artigo("POO", palavrasChave, "Resumo artigo 3", TipoPublicacao.Conferencia, new Date(124,3,13));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);
                artigo3.adicionarAutor(autor3);

                Map<Date,Integer> downloads = new HashMap<>();
                downloads.put(new Date(124,2,25), 3);
                artigo1.setDownloads(downloads);
                bd.adicionarArtigo(artigo3);
                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Artigos Nao Visualizado/Descarregado Por Periodo");

                System.out.println("Lista Artigos Nao Visualizado/Descarregado Por Periodo: " + bd.artigosNaoDescarregadosVizualizadosPorPeriodo(new Date(124,1,12),new Date(124,10,29)));

        }
        public static void testarTop3() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                Artigo artigo3 = new Artigo("POO", palavrasChave, "Resumo artigo 3", TipoPublicacao.Conferencia, new Date(124,3,13));
                Artigo artigo4 = new Artigo("Java", palavrasChave, "Resumo artigo 4", TipoPublicacao.Jornal, new Date(124,4,6));

                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);
                artigo3.adicionarAutor(autor3);
                artigo4.adicionarAutor(autor2);
                artigo4.adicionarAutor(autor3);

                Map<Date,Integer> downloads = new HashMap<>();
                downloads.put(new Date(124,2,25), 20);
                artigo1.setDownloads(downloads);
                artigo2.setDownloads(downloads);
                artigo3.setDownloads(downloads);

                Map<Date,Integer> visualizacoes = new HashMap<>();
                visualizacoes.put(new Date(124,2,25), 100);
                artigo1.setVisualizacoes(visualizacoes);
                artigo2.setVisualizacoes(visualizacoes);
                artigo3.setVisualizacoes(visualizacoes);

                bd.adicionarArtigo(artigo3);
                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);
                bd.adicionarArtigo(artigo4);

                System.out.println("Teste Top3");

                System.out.println("Top 3: " + bd.top3ArtigosMaisUsadosPorPeriodo(new Date(124,1,12),new Date(124,10,29)));

        }


        public static void testarValidarConsistencia() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Consistencia");

                System.out.println("Consistência: " + bd.validarConsistencia());

        }
        public static void testarRelatorio() {
                BaseDeDados bd = new BaseDeDados();

                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");
                bd.adicionarAutor(autor1);
                bd.adicionarAutor(autor2);
                bd.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);
                artigo2.adicionarAutor(autor1);

                bd.adicionarArtigo(artigo1);
                bd.adicionarArtigo(artigo2);

                System.out.println("Teste Relatorio");

                bd.escreverDadosNoFicheiro();

        }
        //Grafos
        public static void testarAdicionarAutor() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);
        }

        public static void testarAdicionarArtigo() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

        }

        public static void testarAdicionarCitacoes() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                System.out.println("Citações do artigo 1: " + grafoArtigos.getCitacoes(artigo1));

        }
        public static void testarNumeroCitacoesDePrimeiraOrdem() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                System.out.println("Citações 1 ordem: " + grafoArtigos.contarCitacoesDePrimeiraOrdem(artigo1));

        }
        public static void testarNumeroCitacoesDeSegundaOrdem() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                System.out.println("Citações 2 ordem: " + grafoArtigos.contarCitacoesDeSegundaOrdem(artigo1));
        }

        public static void testarNumeroAutocitacoes() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                System.out.println("Autocitacões: " + grafoArtigos.contarAutocitacoes(artigo1));

        }

        public static void testarSubgrafoPorTipo() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                System.out.println("Subgrafo por tipo: " + grafoArtigos.subGrafoPorTipo(TipoPublicacao.Jornal));

        }
        public static void testarConexo() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                grafoArtigos.adicionarCitacao(artigo1, artigo2);
                grafoAutores.adicionarColaboracao(autor1, autor2);
                grafoAutores.adicionarColaboracao(autor1, autor3);
                //vai dar true pq os dois estao conectados um ao outro
                System.out.println("Conexo: " + grafoArtigos.Conexo());

        }
        public static void testarListarColaboradores() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                grafoAutores.adicionarColaboracao(autor1, autor2);
                grafoAutores.adicionarColaboracao(autor1, autor3);
                System.out.println("Colaboradores do autor 1: " + grafoAutores.getColaboradores(autor1));

        }
        public static void testarNumeroColaboradores() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                grafoAutores.adicionarColaboracao(autor1, autor2);
                grafoAutores.adicionarColaboracao(autor1, autor3);
                System.out.println("Numero colaboradores do autor 1: " + grafoAutores.getNColaboradores(autor1));

        }

        public static void testarNumeroArtigosEntreAutores() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                grafoAutores.adicionarColaboracao(autor1, autor2);
                grafoAutores.adicionarColaboracao(autor1, autor3);
                System.out.println("Artigos entre autor 1 e autor 2: " + grafoAutores.numeroDeArtigosEntreAutores(autor1,autor2));

        }

        public static void testarSubGrafoPorFiliacao() {
                Autor autor1 = new Autor("Gonçalo Castro", "Castro", "Universidade De Coimbra", "1234-5678-9123-4567", "ciencia1111", "scholar1111", "scopus1111");
                Autor autor2 = new Autor("Vasco Martins", "Martins", "Universidade Do Porto", "9876-5432-1098-7654", "ciencia2222", "scholar2222", "scopus2222");
                Autor autor3 = new Autor("Rogerio Ribeiro", "Ribeiro", "Universidade Do Porto", "0000-1111-2222-3333", "ciencia3333", "scholar3333", "scopus3333");

                GrafoAutores grafoAutores = new GrafoAutores();
                grafoAutores.adicionarAutor(autor1);
                grafoAutores.adicionarAutor(autor2);
                grafoAutores.adicionarAutor(autor3);

                List<String> palavrasChave = Arrays.asList("POO", "Java");
                Artigo artigo1 = new Artigo("POO em Java", palavrasChave, "Resumo artigo 1", TipoPublicacao.Jornal, new Date(124,5,10));
                artigo1.adicionarAutor(autor1);
                artigo1.adicionarAutor(autor2);

                GrafoArtigos grafoArtigos = new GrafoArtigos();
                grafoArtigos.adicionarArtigo(artigo1);
                Artigo artigo2 = new Artigo("POO avançada", palavrasChave, "Resumo artigo 2", TipoPublicacao.Conferencia, new Date(124,2,23));
                artigo2.adicionarAutor(autor1);
                grafoArtigos.adicionarArtigo(artigo2);

                grafoArtigos.adicionarCitacao(artigo2, artigo1);
                grafoAutores.adicionarColaboracao(autor1, autor2);
                grafoAutores.adicionarColaboracao(autor1, autor3);
                System.out.println("Subgrafo por Filiacao: " + grafoAutores.subGrafoPorFiliacao(autor1.getFiliacao()));

        }

}
