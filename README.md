# @Autowired

##   Em tese a ideia é fazer o conceito chamado injeção de dependência.

 ###    O Spring permite fazer diversas formas:

   
   ### A - Através da anotação em cada atributo:

@Controller
public class MeuController {

    @Autowired
    private UmDao dao;
}

  ### B -  Através da anotação no construtor:

@Controller
public class MeuController {

    private UmDao dao;

    @Autowired
    public MeuController(UmDao dao) {
        this.dao = dao;
    }

}

  ### C -  Através da associação direta:

@Controller
public class MeuController {

    private UmDao dao;

    public MeuController(UmDao dao) {
        this.dao = dao;
    }

}
  
  ## Ambos formatos são válidos e funcionam, tendo prós e contras.

        * A primeira solução é boa no caso de deixar claro tudo que está sendo injetado ou não, contudo é ruim, porque todas vezes precisamos fazer a anotação.

        * A segunda já resolve o problema da primeira, você evita ficar anotando tudo.

        * A terceira foi a solução da galera esquecer de colocar a anotação no construtor, contudo pode não ser muito claro o que está acontecendo ali.

        * Um detalhe muito importante: o Spring só consegue injetar objetos que sejam Components dele.
