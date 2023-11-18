![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)       ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)    ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2328f.svg?style=for-the-badge&logo=mysql&logoColor=white)   ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)  ![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)

# Projeto Integrador(SENAC)

# Psico-Apoia🤝

![Untitled](https://raw.githubusercontent.com/VivianeMayumi/psico-apoia/dev/src/main/resources/static/img/logo_home.png)


### 📖Sobre:

**O projeto Psico-Apoia é uma aplicação web com gerenciamento de dados, tem com objetivo colocar em prática todo conteúdo estudado para a entrega de atividades da disciplina de Projeto Integrador do quinto período do curso de Tecnologia em Análise e Desenvolvimento de Sistemas do Senac.**

>O desenvolvimento das funcionalidades foi construído de acordo com a necessidade de melhorar a saúde mental de pessoas com renda salarial de baixo custo, oferecendo o agendamento de sessões gratuitas de psicoterapia com psicólogos voluntários, para promover a igualdade de oportunidades para todos. primeira versão->[psicoapoia](https://github.com/VivianeMayumi/psico-apoia)

**Agora, neste novo projeto e reconhecendo a importância da educação e conscientização em saúde mental, estamos introduzindo uma nova funcionalidade na plataforma onde os usuários terão acesso a uma seção especial dedicada a informar sobre palestras conduzidas por renomados profissionais da área de saúde mental.
Com o intuito de melhorar a experiência dos usuários e tornar o sistema mais eficiente, estamos realizando uma mudança significativa na parte técnica da plataforma. Esta atualização envolve a integração de um robusto sistema de banco de dados para a persistência de informações dos usuários. Esta mudança é fundamental porque, até o momento, nosso sistema não permitia que as informações fossem mantidas entre sessões. Isso significa que, toda vez que alguém precisava fazer login, era necessário criar um novo usuário, o que resultava em uma experiência menos fluída e eficaz. Com a implementação desse banco de dados, todas as informações de perfil dos usuários, como nome, e-mail, histórico de sessões anteriores e outras informações relevantes, serão armazenadas de forma segura e eficiente. Isso elimina a necessidade de criação de usuário cada vez que alguém acessa a plataforma, proporcionando uma experiência mais conveniente e personalizada.**

**Projeto Integrador- Senac- Tecnologia em Análise e Desenvolvimento de Sistemas.**

## 💻Funcionalidades:

-   Usuários poderão navegar nas páginas de home, quem somos, palestras e login;
-   Usuários poderão visualizar a missão da plataforma na página de “quem somos”, o contato de e-mail do adm. caso queira ser um patrocinador, poderão acessar um link onde será redirecionado para uma página de doação e poderá realizar a sua doação para plataforma;
-   Usuários poderão visualizar na página de “Palestras”, com as datas, horários, o tema da palestra, profissionais e visualizar o link que estará disponível quando as mesmas acontecerem;
-   Usuários poderão visualizar em todas as páginas o rodapé, onde conterá as informações de contato caso queira ser um psicólogo voluntário e também conterá o contato do suporte da plataforma;
-   Usuário ao entrar na opção de login ele poderá fazer o primeiro acesso e se cadastrar;
-   Usuário poderá se logar após o cadastro realizado;
-   Usuário paciente e usuário psicólogo poderão visualizar, editar e excluir seu cadastro;
-   Usuário paciente poderá buscar e selecionar o psicólogo que deseja, poderá visualizar a agenda com as datas e horários disponíveis e agendar uma consulta com o psicólogo;
-   Usuário paciente poderá acessar no dia e horário agendado o link que estará disponível (depois de confirmada a sessão pelo psicólogo).
-   Usuário psicólogo poderá visualizar em sessões as datas/horários, nome do paciente, o link das sessões confirmadas, o status, confirmar ou cancelar um agendamento que o paciente agendou;
-   Usuário psicólogo poderá cadastrar novas sessões disponibilizando os dias e horários para os pacientes poderem realizar um agendamento;
-   Usuário paciente e usuário psicólogo poderão ter o acesso de alterar e atualizar a sua senha;
-   Usuário paciente e usuário psicólogo poderão excluir sua conta.

## Modelo Entidade e Relacionamento 

![enter image description here](https://cdn.discordapp.com/attachments/910228177492791337/1174499911039995964/mer-psico-apoio-final.png?ex=6567d147&is=65555c47&hm=271aa04b6137faf251a888c4f0d1bee7ecfe095ca245146f7f8c128f2fd33cae&)

## 📋Pré-requisitos:

Para executar o projeto, será necessário instalar os seguintes programas:

-   JDK20
-   InteliJ community
-  Instalar o MySql Comunity Server

## 👷🏻Começando

Para execução do projeto na máquina local, clone o repositório da API, que se encontra aqui [](https://github.com/VivianeMayumi/psico-apoia-final)[https://github.com/VivianeMayumi/psico-apoia-final](https://github.com/VivianeMayumi/psico-apoia-final)

Para clonar este repositório:

-   cd”psico-apoia-final”
-   git clone [https://github.com/VivianeMayumi/psico-apoia-final](https://github.com/VivianeMayumi/psico-apoia-final)

## 🛠️Execução:

Siga as instruções:
-   Abra o código da API em sua IDE InteliJ(community).
-   Alterar as configurações do MySql no application.properties
-   Para que o projeto rode com sucesso, é necessário ir na pasta service do projeto → em App→clicar com o botão direito do mouse e selecionar a opção Run’App.main()’
-   O comando irá baixar todas as dependências do projeto e criar um diretório target com os artefatos construídos, que incluem o arquivo jar do projeto.
-   Para ter acesso, entre no browser (Google Chrome/Firefox) e acesse a seguinte URL http://**localhost:8080/carregar-home**

## 🚀 Tecnologia utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologia:
|    Tecnologia     	|                    Back-end                  	|   Tecnologia   	|                     Front-end                   	|
|:-----------------:	|:--------------------------------------------:	|:--------------:	|:-----------------------------------------------:	|
| **Java**          	| Linguagem de programação (versão 20)         	| **Figma** 	| Mecanismo de Modelo(versão3.1.1)                        	|
| **Spring**        	| O framework web usado (versão 3.0.6)         	| **Thymeleaf**    	| Mecanismo de Modelo(versão3.1.1)     	|
| **Mapstruct**     	| Mapeamento do back-end (versão 1.5.5)          	| **HTML5**      	| Desenvolvimento do front-end                    	|
| **Lombok**        	| Lib de Java (versão 1.18.26)                    	| **CSS3**       	| Desenvolvimento do front-end                    	|
| **MySQL Comunity Server**  	| Banco de dados (versão 8.032)	| **JQuery**  	| Biblioteca JavaScript (versão3.7.0)              	|
|        	| Banco de dados (versão 8.0)                  	| **Toastr-ngx**      	| Exibição de Notificação (versão2.1.3) 	|
| **Maven**       	| Gerenciador de Pacotes (versão 3.1.8)              	| **JavaScript**	| Linguagem de Programação 	|
                     



## 🖥️Contribuidores:

-   Adelaide [https://github.com/adelaidezhayra](https://github.com/adelaidezhayra)
-   Sara[https://github.com/sara-t-g-silva)](https://github.com/sara-t-g-silva)
-   Sayuri[ https://github.com/SayuriNishida](https://github.com/SayuriNishida)
-   Vinícius [https://github.com/vinivilasboas](https://github.com/vinivilasboas)
-   Viviane [https://github.com/VivianeMayumi](https://github.com/VivianeMayumi)
