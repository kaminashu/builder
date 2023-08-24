package www.uzmd.builder

interface LocalDatabase {
    fun add(userModel: UserModel)
    fun edit(userModel: UserModel)
    fun allList():List<UserModel>
    fun delete()
}