# RoomImplementation
A POC for Room Implementation



Ce POC est pour objectif de implementer ROOM propre.

Pour Room : 
Il y a plusieurs principaux : 

Entyty représente que la schema de BDD
- ENTITY
- ENTITY_RELATION (définit many to many relationship)

@Entity(tableName = "Track")
data class TrackEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "length")
    val length: Int,

    @ColumnInfo(name = "albumId")
    val albumId: String
)


Avec ROOM, il propose des object pour faire query
- QUERY 

class PlayListTrackQuery (

    @Embedded
    val playlist: PlayListEntity,

    @Relation(
        parentColumn = "playlistId",
        entityColumn = "trackId",
        associateBy = Junction(PlayListTrackEntity::class)
    )
    val tracks: List<TrackEntity>
)


- DAO Pour CRUD (aussi pour le LIST)


C'est compliqué de faire save/delet one-to-many et many-to-many
Cette POC est pour trouver la meilleur de pratique pour ce point



