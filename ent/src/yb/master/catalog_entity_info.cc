// Copyright (c) YugaByte, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software distributed under the License
// is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied.  See the License for the specific language governing permissions and limitations
// under the License.

#include "yb/master/catalog_entity_info.h"
#include "yb/master/master.pb.h"

using std::set;

namespace yb {
namespace master {

// ================================================================================================
// CDCStreamInfo
// ================================================================================================

const TableId& CDCStreamInfo::table_id() const {
  auto l = LockForRead();
  return l->data().pb.table_id();
}

std::string CDCStreamInfo::ToString() const {
  auto l = LockForRead();
  return strings::Substitute("$0 [table=$1] {metadata=$2} ", id(), l->data().pb.table_id(),
                             l->data().pb.DebugString());
}

} // namespace master
} // namespace yb
