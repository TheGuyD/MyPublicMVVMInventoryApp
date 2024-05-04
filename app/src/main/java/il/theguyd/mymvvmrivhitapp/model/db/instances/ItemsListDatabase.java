package il.theguyd.mymvvmrivhitapp.model.db.instances;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


import il.theguyd.mymvvmrivhitapp.model.db.dao.ItemDao;

import il.theguyd.mymvvmrivhitapp.model.objects.Item;
import il.theguyd.mymvvmrivhitapp.model.objects.ItemFts;

/**
 * this Database Instance Now Support FTS - Full-Text Search for efficient Text Search within TEXT columns
 * {@link } <a href="https://medium.com/@sienatime/enabling-sqlite-fts-in-room-2-1-75e17d0f0ff8">explain</a>
 * **/
@Database(entities = {Item.class, ItemFts.class}, version = 2 , exportSchema = false)
public abstract class ItemsListDatabase extends RoomDatabase {


    public abstract ItemDao itemDao();
    private static volatile ItemsListDatabase INSTANCE;

    public static synchronized ItemsListDatabase getDatabase( Context context) {
        if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ItemsListDatabase.class, "rivhit_items")

                            /**
                             * adds migration objects to handle transitions between different versions of the database schema
                             * **/
                            .addMigrations(MIGRATION_1_2)
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

/**
 * create virtual table named ItemsFts with the FTS4 Module, the ItemsFts will contain
 * the name and the docid columns.
 * <p><b>name</b> - the name column from Items table</p>
 * <p><b>docid</b> - the _id column (the Primary Key) from Items table (given virtual table FTS4)</p>
 *
 * The virtual table will contain columns from the actual table in which we wish to perform a search
 * **/
    private static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `ItemsFts` USING FTS4(`name`,`id`, content=`Items`)");
            supportSQLiteDatabase.execSQL("INSERT INTO ItemsFts(ItemsFts) VALUES ('rebuild')");
        }
    };




}

