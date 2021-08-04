# itau-cobranca

Módulo que recebe uma notificação de cobrança através de uma interface REST e distribui a informação em diversas filas, para que sejam disparados diversos outros processos de forma assíncrona: envio de e-mail, sms, criação de uma carta entregue fisicamente, ligação telefônica.


## Parâmetros de Debug

Ao executar o projeto localmente é necessário configurar, dentro da IDE de sua preferência, os parâmetros de VM que serão passados para o spring boot.

```bash
--spring.profiles.active=DEV --spring.data.mongodb.password=SenhaMuitoDificil123 --spring.rabbitmq.password=Admin123XX_
```