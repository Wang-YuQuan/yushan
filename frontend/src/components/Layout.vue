<script>
export default {

}
</script>

<template>
    <nav>
        <RouterLink class="link" to="/registerEmployee">新增員工</RouterLink>
        <RouterLink class="link" to="/registerPosition">新增位置</RouterLink>
    </nav>
    <RouterView />
</template>

<style>
.link {
    border: 1px solid #000;
    margin-right: 5px;
}
</style>