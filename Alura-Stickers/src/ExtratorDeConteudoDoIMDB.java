import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {

        // extrair os dados que interessam (titulo, poster, classificação)
        var parse = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parse.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image")
                    .replaceAll("(@+)(.*).jps$", "$1.jpg");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }

        return conteudos;

    }
}