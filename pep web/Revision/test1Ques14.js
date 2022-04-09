let users = [
    {
        name: "Rajneesh",
        age: 34,
        address: {
            local: "22 Alaknanda",
            city: "Dehradun",
            state: "UK",
        },
        orders: [{ id: 1, name: "GOT Book Series" }],
    },
    {
        name: "Bhavesh",
        age: 37,
        address: {
            local: "48 DT Row",
            city: "Hyderabad",
            state: "AP",
        },
    },
    {
        name: "Jasbir",
        age: 38,
        address: {
            local: "196 Lama Bhavan",
            city: "Gangtok",
            state: "Sikkim",
        },
        orders: [
            { id: 1, name: "Chair" },
            { id: 2, name: "PS5" },
        ],
    },
];

function updateUsers(users, userObject, item) {
    //write your code here
    let check = false;
    let idx = -1;
    for (i in users) {
        if (users[i].name === userObject.name) {
            check = true;
            idx = i;
            break;
        }
    }
    if (check) {
        if (users[idx].orders) {
            let exists = false;

            for (i in users[idx].orders) {
                if (users[idx].orders[i].name === item) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                return { msg: "Already ordered!" };
            }

            users[idx].orders.push({
                id: users[idx].orders.length + 1,
                name: item
            });
        } else {
            users[idx].orders = [{ id: 1, name: item }];
        }
    } else {
        if (item) {
            userObject.orders = [{ id: 1, name: item }];
        }
        users.push(userObject);
    }
    return users;
}


console.log(
    JSON.stringify(
        updateUsers(
            users,
            {
                name: "Rajneesh",
                age: 34,
                address: {
                    local: "22 Alaknanda",
                    city: "Dehradun",
                    state: "UK",
                },
            },
            "GOT Book Series"
        )
    ) + "\n\n\n"
);

console.log(
    JSON.stringify(
        updateUsers(users, {
            name: "Ravi",
            age: 24,
            address: {
                local: "25 Iroda",
                city: "Dehradun",
                state: "UK",
            },
        })
    ) + "\n\n\n"
);

console.log(
    JSON.stringify(
        updateUsers(
            users,
            {
                name: "Ravi",
                age: 24,
                address: {
                    local: "25 Iroda",
                    city: "Dehradun",
                    state: "UK",
                },
            },
            "Chair"
        )
    ) + "\n\n\n"
);

console.log(
    JSON.stringify(
        updateUsers(
            users,
            {
                name: "Rajneesh",
                age: 34,
                address: {
                    local: "22 Alaknanda",
                    city: "Dehradun",
                    state: "UK",
                },
            },
            "Fan"
        )
    ) + "\n\n\n"
);