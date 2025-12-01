<template>
  <FormCaSiComponent />
  <table border="1" cellpadding="10" cellspacing="0">
    <thead>
      <tr>
        <th>STT</th>
        <th>Tên ca sĩ</th>
        <th>Quê</th>
        <th>Tuổi</th>
        <th>Số điện thoại</th>
        <th>Hành động</th>
      </tr>
    </thead>
    <tbody>
      <template v-for="(item, index) in listCaSi" :key="item.id">
        <tr>
          <td>{{ index + 1 }}</td>
          <td>{{ item.tenCuaCaSi }}</td>
          <td>{{ item.que }}</td>
          <td>{{ item.tuoi }}</td>
          <td>{{ item.soDienThoai }}</td>
          <td>
            <button @click="handleRemove(item.id)">Xoá ca sĩ</button>
          </td>
        </tr>
      </template>
    </tbody>
  </table>
</template>

<script setup>
import FormCaSiComponent from '@/components/FormCaSiComponent.vue'
import { deleteCaSi, getDanhSachCaSi } from '@/service/CaSiService'
import { onMounted, ref } from 'vue'
const listCaSi = ref([])
// goi ham getDanhSachCaSi
const fetchDanhSachCaSi = async () => {
  listCaSi.value = await getDanhSachCaSi()
}
// vao 1 phat khoi tao gia tri luon => onMounted
onMounted(fetchDanhSachCaSi)
// chuc nang xoa
const handleRemove = async (id) => {
  await deleteCaSi(id)
  // Sau khi xoa xong thi goi lai fetch de hien thi du lieu moi nhat
  await fetchDanhSachCaSi()
}
</script>

<style scoped></style>
