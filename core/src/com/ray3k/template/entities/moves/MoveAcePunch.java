package com.ray3k.template.entities.moves;

import com.ray3k.template.entities.*;

import static com.ray3k.template.AnimationName.*;

public class MoveAcePunch extends MoveSpecialTemplate {
    public MoveAcePunch() {
        airFriction = 0f;
        groundFriction = 1400f;
        attackAnim = ACE_PUNCH.animation;
        gravity = 2000f;
        hSpeed = 0f;
        vSpeed = 0f;
    }
}
