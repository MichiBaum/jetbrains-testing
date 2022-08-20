package michibaum.com.db

import org.ktorm.database.*
import org.ktorm.dsl.QueryRowSet
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.BaseTable
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import javax.xml.crypto.Data

data class User
    (
    val id: Int,
    val name: String)

object Users : BaseTable<User>("users") {
    val id = int("id").primaryKey()
    val name = varchar("name")

    override fun doCreateEntity(row: QueryRowSet, withReferences: Boolean): User =
        User(
            row[id] ?: 0,
            row[name].orEmpty()
        )
}