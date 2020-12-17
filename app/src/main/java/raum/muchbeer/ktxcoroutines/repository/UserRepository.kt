package raum.muchbeer.ktxcoroutines.repository

import kotlinx.coroutines.delay
import raum.muchbeer.ktxcoroutines.model.User

class UserRepository {


    suspend fun getListofUsers() : List<User> {

        delay(5000)
        val users : List<User> = listOf(
            User(1, "George"),
            User(2, "Dotto"),
            User(3, "Gadiel"),
            User(4, "Gianna"),
            User(5, "Giannis"),
            User(6, "Muchbeer"),
            User(7, "Peter")
        )
        return users

    }

}