# itau-cobranca-notifica-email

Módulo que ouve a fila `queue.notifica.cobranca.email`, aplica um template de mensagem e envia o texto para o servidor SMTP


## Parâmetros de Debug

Ao executar o projeto localmente é necessário configurar, dentro da IDE de sua preferência, os parâmetros de VM que serão passados para o spring boot.

```bash
--spring.profiles.active=DEV --spring.data.mongodb.password=SenhaMuitoDificil123 --spring.rabbitmq.password=Admin123XX_
```
