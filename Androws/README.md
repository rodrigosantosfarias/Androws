# ANDROWS 1.0
**ROCARDAN SYSTEMS** — launcher Android 15+ inspirado no Windows Phone 8.1 e Windows 10 Mobile.

## Recursos desta versão inicial
- Selecionável como launcher padrão (categoria HOME).
- Tela inicial com blocos, lista de aplicativos e pesquisa.
- Fixar/desafixar, reorganizar por comandos e ajustar blocos em dois tamanhos.
- 20 cores de destaque, tema claro/escuro e dois perfis visuais básicos.
- Tela de bloqueio demonstrativa (prévia dentro do aplicativo, **não** substitui bloqueio seguro do Android).
- Configuração de acesso a notificações (integração de Live Tiles/contadores ainda pendente).
- Som simples de interação; sons clássicos e toque do sistema ainda não implementados.
- Transição de abertura básica com fade; animações Metro avançadas ainda pendentes.

## Compilar no GitHub usando somente celular
1. Crie um repositório GitHub, por exemplo `Androws`.
2. Extraia este ZIP e envie **o conteúdo da pasta Androws**, incluindo `.github/workflows/android-apk.yml`, para a raiz do repositório (GitHub web permite upload de arquivos, mas para pastas e arquivos ocultos pode ser mais fácil usar um cliente Git Android).
3. Acesse **Actions** > **Compilar Androws APK** > **Run workflow**.
4. Aguarde o build, abra a execução e baixe o artefato `Androws-1.0-APK`.
5. Extraia o APK do artefato ZIP e instale no Android 15+ (permitindo instalação do navegador/gerenciador de arquivos).

O APK gerado é **debug**, para testes pessoais, não uma versão assinada para Play Store. Não foi compilado/testado neste ambiente.

## Limitações
A UI e os recursos não reproduzem o Windows Phone integralmente. Não é possível substituir a tela de bloqueio segura ou controlar todas as transições de apps de terceiros. O uso de QUERY_ALL_PACKAGES pode exigir justificativa ou revisão se distribuído na Play Store.
