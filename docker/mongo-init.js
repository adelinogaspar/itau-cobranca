print("######################## Cria usuários e bancos de dados ##############################")

db = db.getSiblingDB('itau_cobranca_db');
db.createUser(
    {
        user: "dbuser_cobranca",
        pwd: "SenhaMuitoDificil123",
        roles: [
            {
                role: "readWrite",
                db: "itau_cobranca_db"
            }
        ]
    }
);

db = db.getSiblingDB('itau_notifica_email_db');
db.createUser(
    {
        user: "dbuser_notifica_email",
        pwd: "SenhaMuitoDificil123",
        roles: [
            {
                role: "readWrite",
                db: "itau_notifica_email_db"
            }
        ]
    }
);

print("######################## FIM ##############################")
