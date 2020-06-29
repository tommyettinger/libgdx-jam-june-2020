package com.ray3k.template.entities.moves;

import com.badlogic.gdx.audio.Sound;
import com.ray3k.template.*;
import com.ray3k.template.entities.*;
import com.ray3k.template.entities.projectiles.*;
import com.ray3k.template.screens.*;

import static com.ray3k.template.AnimationName.*;
import static com.ray3k.template.JamGame.*;

public class MoveTomSkiBolt extends MoveSpecialTemplate {
    public MoveTomSkiBolt() {
        airFriction = 0f;
        groundFriction = 2400f;
        attackAnim = MARIO_BLAST.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
    
    @Override
    public void update(PerformerEntity performer, float delta) {
        super.update(performer, delta);
        
        if (performer.fireProjectileEvent) {
            var projectile = new Projectile();
            projectile.skinName = ProjectileSkinName.TOM_SKI_BOLT;
            projectile.animationName = ProjectileAnimationName.STATIC;
            projectile.parent = performer;
    
            projectile.damage = 10f;
            projectile.force = 2000f;
            projectile.forceAngle = 30f;
            
            GameScreen.gameScreen.entityController.add(projectile);
            var projectileSpeed = 1200f;
            if (performer.skeleton.getRootBone().getScaleX() < 0) {
                projectile.setMotion(projectileSpeed, 180);
                projectile.skeleton.getRootBone().setScaleX(-1);
            }
            else projectile.setMotion(projectileSpeed, 0);
            projectile.acceleration = 0;
            projectile.setPosition(performer.projectileX, performer.projectileY);
        }
    
        if (performer.soundEvent) {
            Sound sound = assetManager.get("sfx/lightning.mp3");
            sound.play();
        }
    }
}
