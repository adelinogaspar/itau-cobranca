db.createUser(
    {
        user: "dbuser",
        pwd: "SenhaMuitoDificil123",
        roles: [
            {
                role: "readWrite",
                db: "itau"
            }
        ]
    }
);