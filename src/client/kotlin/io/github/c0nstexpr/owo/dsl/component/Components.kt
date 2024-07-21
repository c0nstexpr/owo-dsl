package io.github.c0nstexpr.owo.dsl.component

import io.github.c0nstexpr.owo.dsl.DslBuilder
import io.github.c0nstexpr.owo.dsl.orderedText
import io.wispforest.owo.ui.core.Component

inline fun blockComponent(crossinline block: BlockComponentBuilder.() -> Unit) =
    component(BlockComponentBuilder().apply(block), BlockComponentBuilder::build)

inline fun box(crossinline block: BoxBuilder.() -> Unit = {}) =
    component(BoxBuilder().apply(block), BoxBuilder::build)

inline fun button(crossinline block: ButtonBuilder.() -> Unit = {}) =
    component(ButtonBuilder().apply(block), ButtonBuilder::build)

inline fun buttonWidget(crossinline block: ButtonWidgetBuilder.() -> Unit) =
    component(ButtonWidgetBuilder().apply(block), ButtonWidgetBuilder::build)

inline fun checkbox(crossinline block: CheckboxBuilder.() -> Unit) =
    component(CheckboxBuilder().apply(block), CheckboxBuilder::build)

inline fun checkboxWidget(crossinline block: CheckboxWidgetBuilder.() -> Unit) =
    component(CheckboxWidgetBuilder().apply(block), CheckboxWidgetBuilder::build)

inline fun collapsible(crossinline block: CollapsibleBuilder.() -> Unit) =
    component(CollapsibleBuilder().apply(block), CollapsibleBuilder::build)

inline fun colorPicker(crossinline block: ColorPickerBuilder.() -> Unit) =
    component(ColorPickerBuilder().apply(block), ColorPickerBuilder::build)

inline fun discreteSlider(crossinline block: DiscreteSliderBuilder.() -> Unit) =
    component(DiscreteSliderBuilder().apply(block), DiscreteSliderBuilder::build)

inline fun <T : Component> draggable(crossinline block: DraggableBuilder<T>.() -> Unit) =
    component(DraggableBuilder<T>().apply(block), DraggableBuilder<T>::build)

inline fun dropdown(crossinline block: DropdownBuilder.() -> Unit) =
    component(DropdownBuilder().apply(block), DropdownBuilder::build)

inline fun editBoxWidget(crossinline block: EditBoxBuilder.() -> Unit) =
    component(EditBoxBuilder().apply(block), EditBoxBuilder::build)

inline fun entityComponent(crossinline block: EntityComponentBuilder.() -> Unit) =
    component(EntityComponentBuilder().apply(block), EntityComponentBuilder::build)

inline fun flowLayout(crossinline block: FlowLayoutBuilder.() -> Unit) =
    component(FlowLayoutBuilder().apply(block), FlowLayoutBuilder::build)

inline fun gridLayout(crossinline block: GridLayoutBuilder.() -> Unit) =
    component(GridLayoutBuilder().apply(block), GridLayoutBuilder::build)

inline fun itemComponent(crossinline block: ItemComponentBuilder.() -> Unit) =
    component(ItemComponentBuilder().apply(block), ItemComponentBuilder::build)

inline fun label(crossinline block: LabelBuilder.() -> Unit) =
    component(LabelBuilder().apply(block), LabelBuilder::build)

inline fun <T : Component> overlay(crossinline block: OverlayBuilder<T>.() -> Unit) =
    component(OverlayBuilder<T>().apply(block), OverlayBuilder<T>::build)

inline fun <T : Component> renderEffector(crossinline block: RenderEffectorBuilder<T>.() -> Unit) =
    component(RenderEffectorBuilder<T>().apply(block), RenderEffectorBuilder<T>::build)

inline fun <T : Component> scroller(crossinline block: ScrollerBuilder<T>.() -> Unit) =
    component(ScrollerBuilder<T>().apply(block), ScrollerBuilder<T>::build)

inline fun slider(crossinline block: SliderBuilder.() -> Unit) =
    component(SliderBuilder().apply(block), SliderBuilder::build)

inline fun slimSlider(crossinline block: SlimSliderBuilder.() -> Unit) =
    component(SlimSliderBuilder().apply(block), SlimSliderBuilder::build)

inline fun smallCheckbox(crossinline block: SmallCheckboxBuilder.() -> Unit) =
    component(SmallCheckboxBuilder().apply(block), SmallCheckboxBuilder::build)

inline fun spacer(crossinline block: SpacerBuilder.() -> Unit) =
    component(SpacerBuilder().apply(block), SpacerBuilder::build)

inline fun spriteComponent(crossinline block: SpriteComponentBuilder.() -> Unit) =
    component(SpriteComponentBuilder().apply(block), SpriteComponentBuilder::build)

inline fun stackLayout(crossinline block: StackLayoutBuilder.() -> Unit) =
    component(StackLayoutBuilder().apply(block), StackLayoutBuilder::build)

inline fun textArea(crossinline block: TextAreaBuilder.() -> Unit) =
    component(TextAreaBuilder().apply(block), TextAreaBuilder::build)

inline fun textBoxComponent(crossinline block: TextBoxBuilder.() -> Unit) =
    component(TextBoxBuilder().apply(block), TextBoxBuilder::build)

inline fun textFieldWidget(crossinline block: TextFieldWidgetBuilder.() -> Unit) =
    component(TextFieldWidgetBuilder().apply(block), TextFieldWidgetBuilder::build)

inline fun textureComponent(crossinline block: TextureComponentBuilder.() -> Unit) =
    component(TextureComponentBuilder().apply(block), TextureComponentBuilder::build)

inline fun tooltip(crossinline block: TooltipBuilder.() -> Unit) = object : TooltipBuilder {
    override var orderedTextBuilder = orderedText()
}.apply(block)

class IdComponent<T : Any>(val id: String, builder: DslBuilder<T>) : DslBuilder<T> by builder

fun <T : ComponentBuilder> component(crossinline block: T.() -> Unit)
