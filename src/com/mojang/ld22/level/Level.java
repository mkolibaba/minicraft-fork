package com.mojang.ld22.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mojang.ld22.entity.creature.AirWizard;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.creature.Player;
import com.mojang.ld22.entity.creature.Slime;
import com.mojang.ld22.entity.creature.Zombie;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.level.levelgen.LevelGen;
import com.mojang.ld22.level.tile.Tile;

import static com.mojang.ld22.Global.DEFAULT_RANDOM;

public class Level {
    public int w, h;

    public byte[] tiles;
    public byte[] data;
    public List<List<Entity>> entitiesInTiles;

    public int grassColor = 141;
    public int dirtColor = 322;
    public int sandColor = 550;
    private int depth;
    public int monsterDensity = 8;

    public List<Entity> entities = new ArrayList<>();
    private Comparator<Entity> spriteSorter = Comparator.comparingInt(e -> e.y);

    public Level(int w, int h, int level, Level parentLevel) {
        if (level < 0) {
            dirtColor = 222;
        }
        this.depth = level;
        this.w = w;
        this.h = h;
        byte[][] maps;

        if (level == 1) {
            dirtColor = 444;
        }
        if (level == 0)
            maps = LevelGen.createAndValidateTopMap(w, h);
        else if (level < 0) {
            maps = LevelGen.createAndValidateUndergroundMap(w, h, -level);
            monsterDensity = 4;
        } else {
            maps = LevelGen.createAndValidateSkyMap(w, h); // Sky level
            monsterDensity = 4;
        }

        tiles = maps[0];
        data = maps[1];

        if (parentLevel != null) {
            for (int y = 0; y < h; y++)
                for (int x = 0; x < w; x++) {
                    if (parentLevel.getTile(x, y) == Tile.stairsDown) {

                        setTile(x, y, Tile.stairsUp, 0);
                        if (level == 0) {
                            setTile(x - 1, y, Tile.hardRock, 0);
                            setTile(x + 1, y, Tile.hardRock, 0);
                            setTile(x, y - 1, Tile.hardRock, 0);
                            setTile(x, y + 1, Tile.hardRock, 0);
                            setTile(x - 1, y - 1, Tile.hardRock, 0);
                            setTile(x - 1, y + 1, Tile.hardRock, 0);
                            setTile(x + 1, y - 1, Tile.hardRock, 0);
                            setTile(x + 1, y + 1, Tile.hardRock, 0);
                        } else {
                            setTile(x - 1, y, Tile.dirt, 0);
                            setTile(x + 1, y, Tile.dirt, 0);
                            setTile(x, y - 1, Tile.dirt, 0);
                            setTile(x, y + 1, Tile.dirt, 0);
                            setTile(x - 1, y - 1, Tile.dirt, 0);
                            setTile(x - 1, y + 1, Tile.dirt, 0);
                            setTile(x + 1, y - 1, Tile.dirt, 0);
                            setTile(x + 1, y + 1, Tile.dirt, 0);
                        }
                    }

                }
        }

        entitiesInTiles = new ArrayList<>(w * h);
        for (int i = 0; i < w * h; i++) {
            entitiesInTiles.add(new ArrayList<>());
        }

        if (level == 1) {
            AirWizard aw = new AirWizard();
            aw.x = w * 8;
            aw.y = h * 8;
            add(aw);
        }
    }

    public boolean notInBounds(int x, int y) {
        return x < 0 || y < 0 || x >= this.w || y >= this.h;
    }

    public void renderBackground(Screen screen, int xScroll, int yScroll) {
        int xo = xScroll >> 4;
        int yo = yScroll >> 4;
        int w = (screen.w + 15) >> 4;
        int h = (screen.h + 15) >> 4;
        screen.setOffset(xScroll, yScroll);
        for (int y = yo; y <= h + yo; y++) {
            for (int x = xo; x <= w + xo; x++) {
                getTile(x, y).render(screen, this, x, y);
            }
        }
        screen.setOffset(0, 0);
    }

    private List<Entity> rowSprites = new ArrayList<>();

    public Player player;

    public void renderSprites(Screen screen, int xScroll, int yScroll) {
        int xo = xScroll >> 4;
        int yo = yScroll >> 4;
        int w = (screen.w + 15) >> 4;
        int h = (screen.h + 15) >> 4;

        screen.setOffset(xScroll, yScroll);
        for (int y = yo; y <= h + yo; y++) {
            for (int x = xo; x <= w + xo; x++) {
                if (this.notInBounds(x, y)) continue;
                rowSprites.addAll(entitiesInTiles.get(x + y * this.w));
            }
            if (rowSprites.size() > 0) {
                sortAndRender(screen, rowSprites);
            }
            rowSprites.clear();
        }
        screen.setOffset(0, 0);
    }

    public void renderLight(Screen screen, int xScroll, int yScroll) {
        int xo = xScroll >> 4;
        int yo = yScroll >> 4;
        int w = (screen.w + 15) >> 4;
        int h = (screen.h + 15) >> 4;

        screen.setOffset(xScroll, yScroll);
        int r = 4;
        for (int y = yo - r; y <= h + yo + r; y++) {
            for (int x = xo - r; x <= w + xo + r; x++) {
                if (this.notInBounds(x, y)) continue;
                List<Entity> entities = entitiesInTiles.get(x + y * this.w);
                for (Entity e : entities) {
                    // e.render(screen);
                    int lr = e.getLightRadius();
                    if (lr > 0) screen.renderLight(e.x - 1, e.y - 4, lr * 8);
                }
                int lr = getTile(x, y).getLightRadius(this, x, y);
                if (lr > 0) screen.renderLight(x * 16 + 8, y * 16 + 8, lr * 8);
            }
        }
        screen.setOffset(0, 0);
    }

    // private void renderLight(Screen screen, int x, int y, int r) {
    // screen.renderLight(x, y, r);
    // }

    private void sortAndRender(Screen screen, List<Entity> list) {
        list.sort(spriteSorter);
        for (Entity entity : list) {
            entity.render(screen);
        }
    }

    public Tile getTile(int x, int y) {
        if (this.notInBounds(x, y)) return Tile.ROCK;
        return Tile.tiles[tiles[x + y * w]];
    }

    public void setTile(int x, int y, Tile t, int dataVal) {
        if (this.notInBounds(x, y)) return;
        tiles[x + y * w] = t.id;
        data[x + y * w] = (byte) dataVal;
    }

    public int getData(int x, int y) {
        if (this.notInBounds(x, y)) return 0;
        return data[x + y * w] & 0xff;
    }

    public void setData(int x, int y, int val) {
        if (this.notInBounds(x, y)) return;
        data[x + y * w] = (byte) val;
    }

    public void addAll(Collection<? extends Entity> entities) {
        entities.forEach(this::add);
    }

    public void add(Entity entity) {
        if (entity instanceof Player) {
            player = (Player) entity;
        }
        entity.removed = false;
        entities.add(entity);
        entity.init(this);

        insertEntity(entity.x >> 4, entity.y >> 4, entity);
    }

    public void remove(Entity e) {
        entities.remove(e);
        int xto = e.x >> 4;
        int yto = e.y >> 4;
        removeEntity(xto, yto, e);
    }

    private void insertEntity(int x, int y, Entity e) {
        if (this.notInBounds(x, y)) return;
        entitiesInTiles.get(x + y * w).add(e);
    }

    private void removeEntity(int x, int y, Entity e) {
        if (this.notInBounds(x, y)) return;
        entitiesInTiles.get(x + y * w).remove(e);
    }

    public void trySpawn(int count) {
        this.addAll(
                IntStream.range(0, count)
                        .mapToObj(ignored -> {
                            int minLevel = 1;
                            int maxLevel = 1;
                            if (depth < 0) {
                                maxLevel = (-depth) + 1;
                            } else if (depth > 0) {
                                minLevel = maxLevel = 4;
                            }

                            int lvl = DEFAULT_RANDOM.nextInt(maxLevel - minLevel + 1) + minLevel;
                            return DEFAULT_RANDOM.nextInt(2) == 0
                                    ? new Slime(lvl)
                                    : new Zombie(lvl);
                        })
                        .filter(mob -> mob.findStartPos(this))
                        .collect(Collectors.toList())
        );
    }

    public void tick() {
        trySpawn(1);

        for (int i = 0; i < w * h / 50; i++) {
            int xt = DEFAULT_RANDOM.nextInt(w);
            int yt = DEFAULT_RANDOM.nextInt(w);
            getTile(xt, yt).tick(this, xt, yt);
        }
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            int xto = e.x >> 4;
            int yto = e.y >> 4;

            e.tick();

            if (e.removed) {
                entities.remove(i--);
                removeEntity(xto, yto, e);
            } else {
                int xt = e.x >> 4;
                int yt = e.y >> 4;

                if (xto != xt || yto != yt) {
                    removeEntity(xto, yto, e);
                    insertEntity(xt, yt, e);
                }
            }
        }
    }

    public List<Entity> getEntities(int x0, int y0, int x1, int y1) {
        List<Entity> result = new ArrayList<>();
        int xt0 = (x0 >> 4) - 1;
        int yt0 = (y0 >> 4) - 1;
        int xt1 = (x1 >> 4) + 1;
        int yt1 = (y1 >> 4) + 1;
        for (int y = yt0; y <= yt1; y++) {
            for (int x = xt0; x <= xt1; x++) {
                if (this.notInBounds(x, y)) continue;
                List<Entity> entities = entitiesInTiles.get(x + y * this.w);
                for (Entity e : entities) {
                    if (e.intersects(x0, y0, x1, y1)) result.add(e);
                }
            }
        }
        return result;
    }
}