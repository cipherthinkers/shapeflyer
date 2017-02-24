package com.cipherthinkers.shapeflyer.flyschool;

/**
 * A simple list of the pre-cooked Blue Prints
 * Nomenclature is simple :
 * <Shape_Name>_<Origin_Point>
 *
 * Currently using {@link BeizerPath} and {@link SingleLinePath} to create all these blue prints
 *
 * Created by avin on 20/01/17.
 */

public enum PATHS {
    //S Shapes
    S_BOTTOM_LEFT, S_INVERTED_BOTTOM_RIGHT, S_TOP_RIGHT, S_INVERTED_TOP_LEFT,

    //Lines
    LINE_DIAGONAL_BOTTOM_LEFT, LINE_DIAGONAL_BOTTOM_RIGHT, LINE_DIAGONAL_TOP_LEFT, LINE_DIAGONAL_TOP_RIGHT,
    LINE_MIDDLE_TOP, LINE_MIDDLE_BOTTOM, LINE_MIDDLE_LEFT, LINE_MIDDLE_RIGHT
    ;

    private FlyBluePrint mFlyBluePrint;

    public FlyBluePrint getmFlyBluePrint() {
        if(mFlyBluePrint == null) {
            switch (this) {
                case S_BOTTOM_LEFT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0, 1),
                            FlyPath.getBeizerPath(
                                    new FPoint(1.4f, -0.35f),
                                    new FPoint(-0.5f, -0.8f),
                                    new FPoint(1, -1)
                            ));
                    break;

                case S_INVERTED_BOTTOM_RIGHT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(1, 1),
                            FlyPath.getBeizerPath(
                                    new FPoint(-1.5f, -0.35f),
                                    new FPoint(0.5f, -0.8f),
                                    new FPoint(-1, -1)
                            ));
                    break;

                case S_TOP_RIGHT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(1, 0),
                        FlyPath.getBeizerPath(
                                new FPoint(-1.8f, 0.35f),
                                new FPoint(0.5f, 0.8f),
                                new FPoint(-1, 0.9f)
                        )
                    );
                    break;

                case S_INVERTED_TOP_LEFT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0, 0),
                            FlyPath.getBeizerPath(
                                new FPoint(1.5f, 0.35f),
                                new FPoint(-0.5f, 0.8f),
                                new FPoint(1, 0.9f)
                            )
                    );
                    break;

                case LINE_DIAGONAL_BOTTOM_LEFT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0, 1),
                            FlyPath.getSimpleLinePath(new FPoint(1, 0f))
                    );
                    break;

                case LINE_DIAGONAL_BOTTOM_RIGHT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(1, 1),
                            FlyPath.getSimpleLinePath(new FPoint(0, 0f))
                    );
                    break;

                case LINE_DIAGONAL_TOP_LEFT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0, 0),
                            FlyPath.getSimpleLinePath(new FPoint(1f, 1f))
                    );
                    break;

                case LINE_DIAGONAL_TOP_RIGHT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(1, 0),
                            FlyPath.getSimpleLinePath(new FPoint(0f, 1f))
                    );
                    break;

                case LINE_MIDDLE_TOP:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0.5f, 0),
                            FlyPath.getSimpleLinePath(new FPoint(0.5f, 1f))
                    );
                    break;

                case LINE_MIDDLE_BOTTOM:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0.5f, 1),
                            FlyPath.getSimpleLinePath(new FPoint(0.5f, 0f))
                    );
                    break;

                case LINE_MIDDLE_LEFT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(0f, 0.5f),
                            FlyPath.getSimpleLinePath(new FPoint(1f, 0.5f))
                    );
                    break;

                case LINE_MIDDLE_RIGHT:
                    mFlyBluePrint = new FlyBluePrint(new FPoint(1f, 0.5f),
                            FlyPath.getSimpleLinePath(new FPoint(0f, 0.5f))
                    );
                    break;
            }
        }
        return mFlyBluePrint;
    }
}
